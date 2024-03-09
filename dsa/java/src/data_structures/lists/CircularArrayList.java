package data_structures.lists;

import data_structures.utilities.Utils;


/**
 * A circular array list. Allows insertion/removal at the start and end of the array in O(1) time.
 * Warnings: Not thread-safe.
 */
public class CircularArrayList<T> implements IList<T> {

    private final static int DEFAULT_CAPACITY = 100; // initial default capacity
    private final static int RESIZE_FACTOR = 2; // factor to resize by if needed
    private final int _initialSize;
    private T[] _array; // internal array
    private int _numElements = 0; // num of current elements in array

    private int _startIndex = 0; // index of the first element in the array
    private int _endIndex = 0; // index of the last element in the array

    public CircularArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public CircularArrayList(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("Initial size must be greater than 1");
        }

        _array = (T[]) new Object[initialSize];
        _initialSize = initialSize;
    }


    /**
     * Checks if the list contains the element.
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < _numElements; i++) {
            if (Utils.equals(_array[(_startIndex+i)%_array.length], element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all elements from the list
     */
    @Override
    public void clear() {
        _array = (T[]) new Object[_initialSize];
        _numElements = 0;
        _startIndex = 0;
        _endIndex = 0;
    }

    /**
     * Returns the size of the list
     */
    @Override
    public int size() {
        return _numElements;
    }

    /**
     * Checks if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return (_numElements == 0);
    }

    /**
     * Gets the element at the specified index
     */
    @Override
    public T get(int index) {
        if (index >= _numElements || index < 0) { throw new IndexOutOfBoundsException(); }
        index = (_startIndex+index)%_array.length; // change index to internal array representation
        return _array[index];
    }

    /**
     * Returns the first index containing the element or -1 if it is not in the list.
     */
    @Override
    public int indexOf(T element) {
        for (int i = 0; i < _numElements; i++) {
            if (Utils.equals(_array[(_startIndex+i)%_array.length], element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds the element to the end of the list
     */
    @Override
    public void add(T element) {
        if (_numElements == _array.length) {
            resize();
        }
        if (_numElements != 0) {
            _endIndex = (_endIndex+1)%_array.length;
        }
        _array[_endIndex] = element;
        _numElements++;
    }

    /**
     * Sets the specified index to the element (replacing the previous element).
     */
    @Override
    public void set(int index, T element) {
        if (index >= _numElements || index < 0) { throw new IndexOutOfBoundsException(); }

        index = (_startIndex+index)%_array.length; // change index to internal array representation
        _array[index] = element;
    }

    /**
     * Removes the element at the specified index.
     */
    @Override
    public T remove(int index) {
        if (index >= _numElements || index < 0) { throw new IndexOutOfBoundsException(); }

        int i = (_startIndex+index)%_array.length; // change index to internal array representation

        T element = _array[i];

        // We have to move elements to replace the hole. We can either move the elements before or the elements after it; we will do whichever is less
        if (index <= _numElements/2) { // Move from start index
            while (i != _startIndex) {
                _array[i%_array.length] = _array[(i-1)%_array.length];
                i--;
            }
            _startIndex = (_startIndex+1)%_array.length;
        } else { // Move from end index
            while (i != _endIndex) {
                _array[i%_array.length] = _array[(i+1)%_array.length];
                i++;
            }
            _endIndex = (_endIndex-1)%_array.length;
        }

        _numElements--;
        return element;
    }

    /**
     * Removes the first instance of an element. Returns true if an element was removed or false if not.
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
        for (int i = 0; i < _numElements; i++) {
            newArray[i] = _array[(_startIndex+i)%_array.length];
        }

        return newArray;
    }

    /**
     * Resizes the internal array
     */
    private void resize() {
        T[] newArray = (T[]) new Object[_array.length*RESIZE_FACTOR];
        for (int i = 0; i < _numElements; i++) {
            newArray[i] = _array[(_startIndex+i)%_array.length];
        }

        _startIndex = 0;
        _endIndex = _numElements-1;

        _array = newArray;
    }
}
