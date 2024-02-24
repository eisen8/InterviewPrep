package data_structures.trees;

public class BinaryHeap<T extends Comparable<T>> {

    public enum SortType {
        MIN, // Sorted with the minimum element first
        MAX // Sorted by the maximum element first
    }

    private T[] _elements; // internal array representation. Starts at index 1 to make calculations easier.
    private int _currentSize; // The current number of elements in the heap.

    private final SortType _type;

    private final int INITIAL_CAPACITY = 100;


    public BinaryHeap() {
        this(SortType.MIN);
    }

    public BinaryHeap(SortType type) {
        _elements = (T[]) new Comparable[INITIAL_CAPACITY]; // Hack to create a generic comparable array
        _currentSize = 0;
        _type = type;
    }

    /**
     * Adds an element to the heap.
     * Time: O(log(n))
     */
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        if (_currentSize == _elements.length-1) {
            resizeHeap();
        }

        int index = _currentSize+1; // add to element to last slot and bubble up
        _elements[index] = element;
        bubbleUp(index);
        _currentSize++;
    }

    /**
     * Clears the entire heap;
     * Time: O(1)
     */
    public void clear() {
        _elements = (T[]) new Comparable[INITIAL_CAPACITY];
        _currentSize = 0;
    }

    /**
     * Checks if the heap contains an element.
     * Time: O(n)
     */
    public boolean contains(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        for (int i = 1; i <= _currentSize; i++) {
            if (_elements[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the minimum element from the heap without removing it
     * Time: O(1)
     */
    public T peek() {
        if (_currentSize == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        return _elements[1];
    }

    /**
     * Removes the minimum element from the heap.
     * Time: O(log(n))
     */
    public T remove() {
        if (_currentSize == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        T result = _elements[1];
        _elements[1] = _elements[_currentSize]; // Place last element in first slot
        _currentSize--;

        // Bubble down to restore order
        bubbleDown(1);

        return result;
    }

    /**
     * Returns the number of elements in the heap
     */
    public int size() {
        return _currentSize;
    }

    /**
     * Bubbles an element from a given index up until it is in the correct position
     */
    private void bubbleUp(int index) {
        boolean done = false;
        while (!done && hasParent(index)) {
            int parent = getParentIndex(index);
            if (compareElements(_elements, parent, index) > 0) {
                swapElements(_elements, index, parent);
                index = parent;
            } else {
                done = true;
            }
        }
    }

    /**
     * Bubbles an element from a given index down until it is in the correct position
     */
    private void bubbleDown(int index) {
        boolean done = false;
        while (!done && hasLeftChild(index)) {
            int left = getLeftChildIndex(index);
            int childToSwap = left; // Assume swap with left child

            if (hasRightChild(index)) {
                int right = getRightChildIndex(index);
                if (compareElements(_elements, right, left) < 0) {
                    childToSwap = right; // Right is smaller, swap with it
                }
            }

            if (compareElements(_elements, index, childToSwap) > 0) {
                swapElements(_elements, index, childToSwap);
                index = childToSwap;
            } else {
                done = true;
            }
        }
    }

    /**
     * Returns the parent index of a given index
     */
    private int getParentIndex(int index) {
        return (index/2);
    }

    /**
     * Returns the index of the left child node of a given index
     */
    private int getLeftChildIndex(int index) {
        return (index*2);
    }

    /**
     * Returns the index of the right child node of a given index
     */
    private int getRightChildIndex(int index) {
        return ((index*2)+1);
    }

    /**
     * Checks if a given index has a left child
     */
    private boolean hasLeftChild(int index) {
        return (_currentSize >= getLeftChildIndex(index));
    }

    /**
     * Checks if a given index has a right child
     */
    private boolean hasRightChild(int index) {
        return (_currentSize >= getRightChildIndex(index));
    }

    /**
     * Checks if the element has a parent (i.e. is not the root node)
     */
    private boolean hasParent(int index) {
        return (getParentIndex(index) != 0);
    }

    /**
     * Swaps the elements at two indices within the array
     */
    private void swapElements(T[] array, int index1, int index2) {
        T temp;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Compares two elements in the array.
     */
    private int compareElements(T[] array, int index1, int index2) {
        T element1 = array[index1];
        T element2 = array[index2];

        if (_type == SortType.MIN) {
            return element1.compareTo(element2);
        } else {
            return element2.compareTo(element1);
        }
    }

    /**
     * Resizes the array
     */
    private void resizeHeap() {
        T[] newArray = (T[]) new Comparable[_elements.length*2];
        System.arraycopy(_elements, 0, newArray, 0, _elements.length);
        _elements = newArray;
    }
}
