package data_structures.trees;

/**
 * A simple binary search tree (not self-balancing)
 */
public class BinarySearchTree<T extends Comparable<T>> {
    /**
     * Represents a node in the tree
     */
    private static class Node<T> {
        public T value;
        public Node<T> left; // Left child node
        public Node<T> right; // Right child node
        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> _root;

    public BinarySearchTree() {

    }

    /**
     * Inserts an element into the tree. Does not support duplicate values being inserted.
     */
    public void insert(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        if (_root == null) {
            _root = new Node<>(element);
        } else {
            boolean finished = false;
            Node<T> currentNode = _root;
            while(!finished) {
                if (currentNode.value.compareTo(element) > 0) { // go left
                    if  (currentNode.left == null) { // insert
                        currentNode.left = new Node<>(element);
                        finished = true;
                    } else { // keep searching
                        currentNode = currentNode.left;
                    }
                } else { // go right
                    if  (currentNode.right == null) { // insert
                        currentNode.right = new Node<>(element);
                        finished = true;
                    } else { // keep searching
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    /**
     * Removes a single instance of an element from the tree. Returns true if an element was removed.
     */
    public boolean remove(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        if (_root == null) { //empty tree
            return false;
        }

        // Handle case where root is the element to be removed
        if (element.compareTo(_root.value) == 0) {
            // Case 1: no leaf nodes, set _root to null
            if (_root.left == null && _root.right == null) {
                _root = null;
                return true;
            }
            // Case 2: one leaf node, replace _root with the single child
            if (_root.left == null) {
                _root = _root.right;
                return true;
            }
            if (_root.right == null) {
                _root = _root.left;
                return true;
            }

            //Case 3: two leaf nodes, replace the _root with the right inorder
            _root.value = getAndRemoveInorder(_root);
            return true;
        }

        // Handle non-root removal
        Node<T> parentNode = getParentNode(element);
        if (parentNode == null) {
            return false; // element doesn't exist
        }

        boolean isRightNode = false;
        if (parentNode.left == null || parentNode.left.value.compareTo(element) != 0) {
            isRightNode = true;
        }
        Node<T> nodeToRemove = isRightNode ? parentNode.right : parentNode.left;

        // Case 1: no leaf nodes, set parent left or right to null
        if (nodeToRemove.left == null && nodeToRemove.right == null) {
            if (isRightNode) {
                parentNode.right = null;
            } else {
                parentNode.left = null;
            }
            return true;
        }
        // Case 2: one leaf node, replace parent left/right with the single child
        if (nodeToRemove.left == null) {
            if (isRightNode) {
                parentNode.right = nodeToRemove.right;
            } else {
                parentNode.left = nodeToRemove.right;
            }
            return true;
        }
        if (nodeToRemove.right == null) {
            if (isRightNode) {
                parentNode.right = nodeToRemove.left;
            } else {
                parentNode.left = nodeToRemove.left;
            }
            return true;
        }

        //Case 3: 2 leaf nodes, replace the node to remove with the inorder node
        if (isRightNode) {
            parentNode.right.value = getAndRemoveInorder(nodeToRemove);
        } else {
            parentNode.left.value = getAndRemoveInorder(nodeToRemove);
        }

        return true;
    }

    /**
     * Returns true if the tree contains an instance of the element. False if not.
     */
    public boolean contains(T element) {
        return (getParentNode(element) != null);
    }

    /**
     * Gets the inorder node value. Which is the smallest (left mode) node of the tree on starting at its right child.
     * Also removes this node from the tree (re-attaching its right children to its parent if necessary).
     */
    private T getAndRemoveInorder(Node<T> node) {
        if (node.right == null) {
            throw new IllegalArgumentException("Inorder must have a right node");
        }

        Node<T> parentNode = node;
        Node<T> currentNode = node.right;
        while(currentNode.left != null) {
            parentNode = currentNode;
            currentNode = currentNode.left;
        }

        // Reattach the children of the inorder node (it only has right children)
        if (parentNode == _root) { // special case for root in which the inorder node will be the right node
            parentNode.right = currentNode.right;
        } else {
            parentNode.left = currentNode.right;
        }

        return currentNode.value;
    }
    private Node<T> getParentNode(T element) {
        if (_root == null) {
            return null;
        }

        Node<T> parentNode = _root;
        Node<T> currentNode = _root;
        while(true) {
            if (currentNode.value.compareTo(element) == 0) {
                return parentNode; // found element
            } else if (currentNode.value.compareTo(element) > 0) { // go left
                if (currentNode.left == null) {
                    return null; // doesn't exist
                } else {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                }
            } else { // go right
                if  (currentNode.right == null) {
                    return null; // doesn't exist
                } else {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                }
            }
        }
    }
}
