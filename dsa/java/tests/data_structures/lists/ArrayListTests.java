package data_structures.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTests extends IListBaseTests {

    public ArrayListTests() {
        super(new ArrayList<>()); // Runs all the base class unit tests
    }

    // ---- Insert any specific unit tests below if needed ----
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
