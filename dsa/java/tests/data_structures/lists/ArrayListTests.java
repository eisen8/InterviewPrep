package data_structures.lists;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTests {
    @Test
    public void size_Zero() {
        ArrayList<String> CUT = new ArrayList<>();

        assertEquals(0, CUT.size());
    }

    @Test
    public void add_FiveIntegers() {
        ArrayList<Integer> CUT = new ArrayList<>();
        CUT.add(0);
        CUT.add(1);
        CUT.add(2);
        CUT.add(3);
        CUT.add(4);

        assertEquals(5, CUT.size());
    }

    @Test
    public void add_CanAddNullValues() {
        ArrayList<Integer> CUT = new ArrayList<>();
        CUT.add(0);
        CUT.add(null);
        CUT.add(null);
        CUT.add(null);
        CUT.add(4);

        assertEquals(5, CUT.size());
    }

    @Test
    public void contains_NullValues_ReturnsTrue() {
        ArrayList<Integer> CUT = new ArrayList<>();
        CUT.add(0);
        CUT.add(null);
        CUT.add(null);
        CUT.add(null);
        CUT.add(4);

        assertTrue(CUT.contains(null));
    }

    @Test
    public void indexOf_NullValues_ReturnsIndex() {
        ArrayList<Integer> CUT = new ArrayList<>();
        CUT.add(0);
        CUT.add(null);
        CUT.add(null);
        CUT.add(null);
        CUT.add(4);

        int index = CUT.indexOf(null);

        assertEquals(1, index);
    }

    @Test
    public void remove_NullValues_RemovesNullValue() {
        ArrayList<Integer> CUT = new ArrayList<>();
        CUT.add(0);
        CUT.add(null);
        CUT.add(null);
        CUT.add(null);
        CUT.add(4);

        boolean didRemove = CUT.remove(null);

        assertEquals(4, CUT.size());
        assertTrue(didRemove);

    }

    @Test
    public void addAndRemoveInteger_ReturnTrue() {
        ArrayList<Integer> CUT = new ArrayList<>();
        Integer toAdd = 3;
        CUT.add(toAdd);

        boolean didRemove = CUT.remove(toAdd);

        assertEquals(0, CUT.size());
        assertTrue(didRemove);
    }

    @Test
    public void removeMissingString_ReturnFalse() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("add");

        boolean didRemove = CUT.remove("removed");

        assertEquals(1, CUT.size());
        assertFalse(didRemove);
    }

    @Test
    public void addAndRemoveNullString_ReturnTrue() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add(null);

        boolean didRemove = CUT.remove(null);

        assertEquals(0, CUT.size());
        assertTrue(didRemove);
    }

    @Test
    public void addAndRemoveStringWithDuplicates_RemovesJustOne() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");

        boolean didRemove = CUT.remove("add");

        assertEquals(2, CUT.size());
        assertTrue(didRemove);
    }

    @Test
    public void indexOf_Element_ReturnsIndex() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("one");
        CUT.add("two");
        CUT.add("three");

        int index = CUT.indexOf("two");

        assertEquals(1, index);
    }

    @Test
    public void indexOf_DuplicateElement_ReturnsFirstIndex() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("one");
        CUT.add("two");
        CUT.add("two");
        CUT.add("three");

        int index = CUT.indexOf("two");

        assertEquals(1, index);
    }

    @Test
    public void indexOf_MissingElement_ReturnsNegOne() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");

        int index = CUT.indexOf("missing");

        assertEquals(-1, index);
    }

    @Test
    public void clearTest() {
        ArrayList<String> CUT = new ArrayList<>();

        CUT.add("add");
        CUT.add("add");
        CUT.add("add");

        CUT.clear();

        assertEquals(0, CUT.size());
        assertTrue(CUT.isEmpty());
    }

    @Test
    public void isEmpty_True() {
        ArrayList<String> CUT = new ArrayList<>();

        boolean result = CUT.isEmpty();

        assertTrue(result);
    }

    @Test
    public void isEmpty_False() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("NotEmpty");
        boolean result = CUT.isEmpty();

        assertFalse(result);
    }

    @Test
    public void resizeTest() {
        ArrayList<String> CUT = new ArrayList<>(1);

        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");

        assertEquals(12, CUT.size());
    }
}
