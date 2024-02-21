package data_structures.lists;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTests {
    @Test
    public void Size_Zero() {
        ArrayList<String> CUT = new ArrayList<>();

        assertEquals(0, CUT.size());
    }

    @Test
    public void Add_FiveIntegers() {
        ArrayList<Integer> CUT = new ArrayList<>();
        CUT.add(0);
        CUT.add(1);
        CUT.add(2);
        CUT.add(3);
        CUT.add(4);

        assertEquals(5, CUT.size());
    }

    @Test
    public void AddAndRemoveInteger_ReturnTrue() {
        ArrayList<Integer> CUT = new ArrayList<>();
        Integer toAdd = 3;
        CUT.add(toAdd);

        boolean didRemove = CUT.remove(toAdd);

        assertEquals(0, CUT.size());
        assertTrue(didRemove);
    }

    @Test
    public void RemoveMissingString_ReturnFalse() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("add");

        boolean didRemove = CUT.remove("removed");

        assertEquals(1, CUT.size());
        assertFalse(didRemove);
    }

    @Test
    public void AddAndRemoveNullString_ReturnTrue() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add(null);

        boolean didRemove = CUT.remove(null);

        assertEquals(0, CUT.size());
        assertTrue(didRemove);
    }

    @Test
    public void AndAndRemoveStringWithDuplicates_RemovesJustOne() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");

        boolean didRemove = CUT.remove("add");

        assertEquals(2, CUT.size());
        assertTrue(didRemove);
    }

    @Test
    public void IndexOf_Element_ReturnsIndex() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("one");
        CUT.add("two");
        CUT.add("three");

        int index = CUT.indexOf("two");

        assertEquals(1, index);
    }

    @Test
    public void IndexOf_DuplicateElement_ReturnsFirstIndex() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("one");
        CUT.add("two");
        CUT.add("two");
        CUT.add("three");

        int index = CUT.indexOf("two");

        assertEquals(1, index);
    }

    @Test
    public void IndexOf_MissingElement_ReturnsNegOne() {
        ArrayList<String> CUT = new ArrayList<>();
        CUT.add("add");
        CUT.add("add");
        CUT.add("add");

        int index = CUT.indexOf("missing");

        assertEquals(-1, index);
    }

    @Test
    public void ClearTest() {
        ArrayList<String> CUT = new ArrayList<>();

        CUT.add("add");
        CUT.add("add");
        CUT.add("add");

        CUT.clear();

        assertEquals(0, CUT.size());
    }

    @Test
    public void ResizeTest() {
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
