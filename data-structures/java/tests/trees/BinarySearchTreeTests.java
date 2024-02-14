package trees;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTests {
    @Test
    public void Contains_NoElements_ReturnsFalse() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();

        boolean result = CUT.contains(5);

        assertFalse(result);
    }

    @Test
    public void Insert_FiveIntegers_InOrder() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();

        CUT.insert(0);
        CUT.insert(1);
        CUT.insert(2);
        CUT.insert(3);
        CUT.insert(4);

        assertTrue(CUT.contains(0));
        assertTrue(CUT.contains(1));
        assertTrue(CUT.contains(2));
        assertTrue(CUT.contains(3));
        assertTrue(CUT.contains(4));
        assertFalse(CUT.contains(-12));
    }

    @Test
    public void Insert_FiveIntegers_InverseOrder() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();

        CUT.insert(4);
        CUT.insert(3);
        CUT.insert(2);
        CUT.insert(1);
        CUT.insert(0);

        assertTrue(CUT.contains(0));
        assertTrue(CUT.contains(1));
        assertTrue(CUT.contains(2));
        assertTrue(CUT.contains(3));
        assertTrue(CUT.contains(4));
        assertFalse(CUT.contains(-12));
    }

    @Test
    public void Insert_FiveIntegers_OutOfOrder() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();

        CUT.insert(3);
        CUT.insert(2);
        CUT.insert(5);
        CUT.insert(1);
        CUT.insert(10);

        assertTrue(CUT.contains(3));
        assertTrue(CUT.contains(2));
        assertTrue(CUT.contains(5));
        assertTrue(CUT.contains(1));
        assertTrue(CUT.contains(10));
        assertFalse(CUT.contains(99));
    }

    @Test
    public void Insert_DuplicateElement() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();

        CUT.insert(3);
        CUT.insert(3);
        CUT.insert(2);
        CUT.insert(3);
        CUT.insert(2);
        CUT.insert(2);

        assertTrue(CUT.contains(2));
        assertTrue(CUT.contains(3));
    }

    @Test
    public void Contains_DoesntContainElements() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();

        CUT.insert(3);
        CUT.insert(2);
        CUT.insert(5);
        CUT.insert(1);
        CUT.insert(10);

        assertFalse(CUT.contains(99));
        assertFalse(CUT.contains(0));
        assertFalse(CUT.contains(4));
        assertFalse(CUT.contains(9));
        assertFalse(CUT.contains(12));
        assertFalse(CUT.contains(15));
        assertFalse(CUT.contains(-3));
    }

    @Test
    public void Remove_NoElements_ReturnsFalse() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();

        boolean result = CUT.remove(5);

        assertFalse(result);
    }

    @Test
    public void Remove_Root() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);

        boolean result = CUT.remove(5);

        assertTrue(result);
        assertFalse(CUT.contains(5));
    }

    @Test
    public void Remove_RootWithOneLeftChild() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);
        CUT.insert(3);

        boolean result = CUT.remove(5);

        assertTrue(result);
        assertFalse(CUT.contains(5));
    }

    @Test
    public void Remove_RootWithOneRightChild() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);
        CUT.insert(7);

        boolean result = CUT.remove(5);

        assertTrue(result);
        assertFalse(CUT.contains(5));
    }

    @Test
    public void Remove_RootWithTwoChildren() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);
        CUT.insert(3);
        CUT.insert(7);

        boolean result = CUT.remove(5);

        assertTrue(result);
        assertFalse(CUT.contains(5));
    }

    @Test
    public void Remove_LeftChildWithNoChildren() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);
        CUT.insert(3);
        CUT.insert(2);
        CUT.insert(7);

        boolean result = CUT.remove(2);

        assertTrue(result);
        assertFalse(CUT.contains(2));
    }

    @Test
    public void Remove_LeftChildWithOneChild() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);
        CUT.insert(3);
        CUT.insert(2);
        CUT.insert(1);
        CUT.insert(7);

        boolean result = CUT.remove(2);

        assertTrue(result);
        assertFalse(CUT.contains(2));
    }

    @Test
    public void Remove_LeftChildWithTwoChildren() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(7);
        CUT.insert(5);
        CUT.insert(3);
        CUT.insert(1);
        CUT.insert(4);

        boolean result = CUT.remove(3);

        assertTrue(result);
        assertFalse(CUT.contains(3));
    }

    @Test
    public void Remove_RightChildWithNoChildren() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);
        CUT.insert(3);
        CUT.insert(10);
        CUT.insert(12);

        boolean result = CUT.remove(12);

        assertTrue(result);
        assertFalse(CUT.contains(12));
    }

    @Test
    public void Remove_RightChildWithOneChild() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);
        CUT.insert(3);
        CUT.insert(10);
        CUT.insert(12);
        CUT.insert(11);

        boolean result = CUT.remove(12);

        assertTrue(result);
        assertFalse(CUT.contains(12));
    }

    @Test
    public void Remove_RightChildWithTwoChildren() {
        BinarySearchTree<Integer> CUT = new BinarySearchTree<>();
        CUT.insert(5);
        CUT.insert(3);
        CUT.insert(10);
        CUT.insert(12);
        CUT.insert(11);
        CUT.insert(13);

        boolean result = CUT.remove(12);

        assertTrue(result);
        assertFalse(CUT.contains(12));
    }
}
