package data_structures.lists;

/**
 * A simplified list interface of the most basic operations
 * @param <T> The type of element in the list
 */
public interface IList<T> {
    /**
     * Checks if the list contains the element.
     */
    public boolean contains(T element);

    /**
     * Removes all elements from the list
     */
    public void clear();

    /**
     * Returns the size of the list
     */
    public int size();

    /**
     * Gets the element at the specified index
     */
    public T get(int index);

    /**
     * Returns the first index containing the element or -1 if it is not in the list.
     */
    public int indexOf (T element);

    /**
     * Adds the element to the end of the list
     */
    public void add(T element);

    /**
     * Sets the specified index to the element (replacing the previous element).
     */
    public void set(int index, T element);

    /**
     * Removes the element at the specified index.
     */
    public T remove(int index);

    /**
     * Removes the first instance of an element. Returns true if an element was removed or false if not.
     */
    public boolean remove(T element);

    /**
     * Returns an array of the elements that make up this list.
     */
    public T[] toArray();
}
