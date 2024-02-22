package data_structures.lists;

import data_structures.utilities.ArrayUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A set of base tests for all classes that implement IList
 */
public abstract class IListBaseTests {
    private static IList<Integer> CUT;

    public IListBaseTests(IList<Integer> list) {
        if (list == null) { throw new IllegalArgumentException("list cannot be null"); }

        CUT = list;
    }

    @BeforeAll
    public static void init() {
        if (CUT != null) {
            CUT.clear();
        }
    }

    /**
     * Parameters for add basic tests.
     */
    private static Stream<Arguments> basicAddParameters() {
        return Stream.of( // (numbers)
                Arguments.of(new Object[]{new Integer[]{1,2,3,4}}), // all in order
                Arguments.of(new Object[]{new Integer[]{4,3,2,1}}), // inverse order
                Arguments.of(new Object[]{new Integer[]{1}}), // 1 element
                Arguments.of(new Object[]{new Integer[]{3,1,2}}), // 3 elements
                Arguments.of(new Object[]{new Integer[]{1,1,1}}), // duplicate elements
                Arguments.of(new Object[]{new Integer[]{3,1,3,1}}), // duplicate elements
                Arguments.of(new Object[]{new Integer[]{3,null,null,1}}), // nulls are fine
                Arguments.of(new Object[]{new Integer[]{3,1,1,5,4,7,8,9,11,15,2,5,18,25,100,3,1,4,56,78,12,33,11,69,8,64,101,112,1}}) // lots of random numbers
        );
    }

    @ParameterizedTest
    @MethodSource("basicAddParameters")
    public void add_BasicTests_CheckSize(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            CUT.add(numbers[i]);
            assertEquals(i+1, CUT.size());
        }
    }

    @ParameterizedTest
    @MethodSource("basicAddParameters")
    public void get_BasicTests(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            CUT.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(numbers[i], CUT.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("basicAddParameters")
    public void remove_indexFromStart_BasicTests(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            CUT.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            Integer removed = CUT.remove(0);
            assertEquals(numbers[i], removed);
            assertEquals(numbers.length-1-i, CUT.size());
        }
    }

    @ParameterizedTest
    @MethodSource("basicAddParameters")
    public void remove_indexFromEnd_BasicTests(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            CUT.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            Integer removed = CUT.remove(CUT.size()-1);
            assertEquals(numbers[numbers.length-1-i], removed);
            assertEquals(numbers.length-1-i, CUT.size());
        }
    }

    @ParameterizedTest
    @MethodSource("basicAddParameters")
    public void remove_elementFromStart_BasicTests(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            CUT.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            boolean removed = CUT.remove(numbers[i]);
            assertTrue(removed);
            assertEquals(numbers.length-1-i, CUT.size());
        }
    }

    @ParameterizedTest
    @MethodSource("basicAddParameters")
    public void remove_elementFromEnd_BasicTests(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            CUT.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            boolean removed = CUT.remove(numbers[numbers.length-1-i]);
            assertTrue(removed);
            assertEquals(numbers.length-1-i, CUT.size());
        }
    }

    @ParameterizedTest
    @MethodSource("basicAddParameters")
    public void indexOf_BasicTests(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            CUT.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            int index = CUT.indexOf(numbers[i]);
            assertEquals(ArrayUtils.firstIndexOf(numbers, numbers[i]), index);
        }
    }

    @ParameterizedTest
    @MethodSource("basicAddParameters")
    public void contains_BasicTests(Integer[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            CUT.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            boolean contains = CUT.contains(numbers[i]);
            assertTrue(contains);
        }
    }

    @Test
    public void contains_DoesNotContainElement_ReturnsFalse() {
        CUT.add(1);
        CUT.add(2);
        CUT.add(3);

        boolean contains = CUT.contains(4);

        assertFalse(contains);
    }

    @Test
    public void contains_EmptyList_ReturnsFalse() {
        assertFalse(CUT.contains(0));
    }

    @Test
    public void contains_AfterClearList_ReturnsFalse() {
        CUT.add(0);
        CUT.clear();

        assertFalse(CUT.contains(0));
    }

    @Test
    public void indexOf_MissingElement_ReturnsNegOne() {
        CUT.add(1);
        CUT.add(2);
        CUT.add(3);

        int index = CUT.indexOf(4);

        assertEquals(-1, index);
    }


    @Test
    public void size_AfterClearList_ReturnsZero() {
        CUT.add(1);
        CUT.clear();

        assertEquals(0, CUT.size());
    }

    @Test
    public void size_EmptyList_ReturnsZero() {
        int size = CUT.size();
        assertEquals(0, size);
    }

    @Test
    public void isEmpty_EmptyList_ReturnsTrue() {
        assertTrue(CUT.isEmpty());
    }

    @Test
    public void isEmpty_NotEmptyList_ReturnsFalse() {
        CUT.add(2);
        assertFalse(CUT.isEmpty());
    }
}