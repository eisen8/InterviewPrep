package data_structures.lists;

import data_structures.utilities.Utils;

/**
 * A doubly linked list
 */
public class DoublyLinkedList<T> implements IList<T> {
    private int _size;
    private LinkNode<T> _head; // The head node of the linked list
    private LinkNode<T> _tail; // Points to the last node in the linked list (index[size-1]).

    /**
     * Initializes an instance of LinkedList
     */
    public DoublyLinkedList() {
        _head = null;
        _tail = null;
        _size = 0;
    }

    /**
     * Checks if the list contains the element.
     * Time: O(n)
     */
    @Override
    public boolean contains(T element) {
        LinkNode<T> currentNode = _head;
        for (int i = 0; i < _size; i++) {
            if (Utils.equals(currentNode.data, element)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    /**
     * Removes all elements from the list.
     * Time: O(1)
     */
    @Override
    public void clear() {
        _head = null;
        _tail = null;
        _size = 0;
    }

    /**
     * Returns the size of the list
     * Time: O(1)
     */
    @Override
    public int size() { return _size; }

    /**
     * Checks if the list is empty.
     */
    @Override
    public boolean isEmpty() { return _size == 0; }

    /**
     * Gets the element at the specified index
     * Time: O(n/2)
     */
    @Override
    public T get(int index) {
        if (index >= _size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return getNodeAt(index).data;
    }

    /**
     * Returns the first index containing the element or -1 if it is not in the list.
     * Time: O(n)
     */
    @Override
    public int indexOf(T element) {
        LinkNode<T> currentNode = _head;
        for (int i = 0; i < _size; i++) {
            if (Utils.equals(currentNode.data, element)) {
                return i;
            }

            currentNode = currentNode.next;
        }

        return -1;
    }

    /**
     * Adds the element to the end of the list
     * Time: O(1)
     */
    @Override
    public void add(T element) {
        if (_size == 0) {
            _head = new LinkNode<>(element);
            _tail = _head;
        } else {
            LinkNode<T> newNode = new LinkNode<>(element);
            LinkNode<T> prevEndNode = _tail;
            newNode.prev = prevEndNode;
            prevEndNode.next = newNode;
            _tail = newNode;
        }
        _size++;
    }

    /**
     * Sets the specified index to the element (replacing the previous element).
     * Time: O(n/2)
     */
    @Override
    public void set(int index, T element) {
        if (index >= _size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        getNodeAt(index).data = element;
    }

    /**
     * Removes the element at the specified index.
     * Time: O(n/2)
     */
    @Override
    public T remove(int index) {
        if (index >= _size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        LinkNode<T> currentNode = getNodeAt(index);

        if (currentNode == _head) { // handle case if we are removing head
            _head = currentNode.next;
            if (_head != null) {
                _head.prev = null;
            }
        } else {
            LinkNode<T> prevNode = currentNode.prev;
            prevNode.next = currentNode.next; // remove by jumping node
            if (prevNode.next != null) {
                prevNode.next.prev = prevNode;
            }
        }

        if (_tail == currentNode) { // update tail if we removed the tail node
            _tail = currentNode.prev;
        }

        _size--;
        return currentNode.data;
    }

    /**
     * Removes the first instance of an element. Returns true if an element was removed or false if not.
     * O(n)
     */
    @Override
    public boolean remove(T element) {
        LinkNode<T> prevNode = _head;
        LinkNode<T> currentNode = _head;
        for (int i = 0; i < _size; i++) {
            if (Utils.equals(currentNode.data, element)) {
                if (currentNode == _head) { // handle case if we are removing head
                    _head = currentNode.next;
                } else {
                    prevNode.next = currentNode.next; // remove by jumping node
                }
                if (_tail == currentNode) { // update tail if we removed the tail node
                    _tail = prevNode;
                }

                _size--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return false;
    }

    /**
     * Returns an array of the elements that make up this list.
     */
    @Override
    public T[] toArray() {
        T[] newArray = (T[]) new Object[_size];
        LinkNode<T> currentNode = _head;
        for (int i = 0; i < _size; i++) {
            newArray[i] = currentNode.data;
            currentNode = currentNode.next;
        }

        return newArray;
    }

    /**
     * Retrieves the node at index
     * time: O(n/2)
     */
    private LinkNode<T> getNodeAt(int index) {
        LinkNode<T> currentNode;
        if (index <= _size/2) { // go forward
            currentNode = _head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else { // go backwards
            currentNode = _tail;
            for (int i = _size-1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode;
    }


    /**
     * Represents a link node in the doubly linked list.
     */
    private static class LinkNode<T> {

        /**
         * The next node in the linked list.
         */
        public LinkNode<T> next;

        /**
         * The prev node in the linked list.
         */
        public LinkNode<T> prev;

        /**
         * The data stored in this node.
         */
        public T data;

        public LinkNode(T data) {
            this.data = data;
            next = null;
        }
    }
}
