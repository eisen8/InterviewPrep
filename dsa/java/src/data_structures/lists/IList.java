package data_structures.lists;

/**
 * A simplified list interface of the most basic operations
 *
 * @param <T> The type of element in the list
 */
public interface IList<T> {
    /**
     * Checks if the list contains the element.
     */
    boolean contains(T element);

    /**
     * Removes all elements from the list
     */
    void clear();

    /**
     * Returns the size of the list
     */
    int size();

    /**
     * Checks if the list is empty.
     */
    boolean isEmpty();

    /**
     * Gets the element at the specified index
     */
    T get(int index);

    /**
     * Returns the first index containing the element or -1 if it is not in the list.
     */
    int indexOf(T element);

    /**
     * Adds the element to the end of the list
     */
    void add(T element);

    /**
     * Sets the specified index to the element (replacing the previous element).
     */
    void set(int index, T element);

    /**
     * Removes the element at the specified index.
     */
    T remove(int index);

    /**
     * Removes the first instance of an element. Returns true if an element was removed or false if not.
     */
    boolean remove(T element);

    /**
     * Returns an array of the elements that make up this list.
     */
    T[] toArray();
}
