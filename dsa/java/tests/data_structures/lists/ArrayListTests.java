package data_structures.lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTests extends IListBaseTests {
    @BeforeEach
    @Override
    void initCUT() {
        CUT = new ArrayList<>();
    }

    // ---- Insert any specific unit tests below if needed ----
    @Test
    public void resizeTest() {
        ArrayList<String> CUT = new ArrayList<>(1);

        for (int i = 0; i < 10000; i++) {
            CUT.add("add");
        }

        assertEquals(10000, CUT.size());
    }
}
