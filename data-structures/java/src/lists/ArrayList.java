package lists;

import java.util.Arrays;

/**
 * An array list that automatically resizes.
 * Warnings: Not thread-safe.
 */
public class ArrayList<T> implements IList<T> {

    private T[] _array; // internal array
    private int _numElements = 0; // num of current elements in array

    private int _maxSize; // max size of current array (will resize if maxSize is reached)

    public ArrayList() {
        this(100);
    }

    public ArrayList(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Initial size must be greater than 0");
        }

        _array = (T[]) new Object[initialSize];
        _maxSize = initialSize;
    }

    /**
     * Checks if the list contains the element.
     * Time: O(n)
     */
    @Override
    public boolean contains(T element) {
        for (T ele : _array) {
            if (ele != null && ele.equals(element)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Removes all elements from the list
     * Time: O(1)
     */
    @Override
    public void clear() {

        _array = (T[]) new Object[_maxSize];
        _numElements = 0;
    }

    /**
     * Returns the number of elements in the list
     * Time: O(1)
     */
    @Override
    public int size() {
        return _numElements;
    }

    /**
     * Gets the element at the specified index
     * Time: O(1)
     */
    @Override
    public T get(int index) {
        return _array[index];
    }

    /**
     * Returns the first index containing the element or -1 if it is not in the list.
     * Time: O(n)
     */
    @Override
    public int indexOf(T element) {
        for (int i = 0; i < _array.length; i++) {

            // Case for null array elements
            if (_array[i] == null) {
                if (element == null) {
                    return i;
                }
                continue;
            }

            if (_array[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Adds the element to the end of the list.
     * Time: O(1)
     */
    @Override
    public void add(T element) {
        if (_array.length == _maxSize) {
            resize();
        }

        _array[_numElements] = element;
        _numElements++;
    }

    /**
     * Sets the specified index to the element (replacing the previous element).
     * Time: O(1)
     */
    @Override
    public void set(int index, T element) {
        _array[index] = element;
    }

    /**
     * Removes the element at the specified index.
     * Time: O(n)
     */
    @Override
    public T remove(int index) {
        if (index >= _numElements) {
            throw new IndexOutOfBoundsException();
        }

        T element = _array[index];
        for (int i = index; i < _numElements - 1; i++) {
            _array[i] = _array[i + 1];
        }

        _numElements--;

        return element;
    }

    /**
     * Removes the first instance of an element. Returns true if an element was removed or false if not.
     * Time: O(n)
     */
    @Override
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    /**
     * Returns an array of the elements that make up this list.
     */
    @Override
    public T[] toArray() {
        T[] newArray = (T[]) new Object[_numElements];
        System.arraycopy(_array, 0, newArray, 0, _numElements);
        return newArray;
    }

    /**
     * Resizes the internal array
     */
    private void resize() {
        _maxSize *= 2;
        T[] newArray = (T[]) new Object[_maxSize];
        System.arraycopy(_array, 0, newArray, 0, _numElements);
        _array = newArray;
    }
}
