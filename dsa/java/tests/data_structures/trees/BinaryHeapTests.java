package data_structures.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import data_structures.utilities.ArrayUtils;

import java.util.stream.Stream;

public class BinaryHeapTests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(new int[]{1,2,3,4}, new int[]{1,2,3,4}), // all in order
                Arguments.of(new int[]{4,3,2,1}, new int[]{1,2,3,4}), // inverse order
                Arguments.of(new int[]{1}, new int[]{1}), // 1 element
                Arguments.of(new int[]{3,1,2}, new int[]{1,2,3}), // 3 elements
                Arguments.of(new int[]{1,1,1}, new int[]{1,1,1}), // duplicate elements
                Arguments.of(new int[]{3,1,3,1}, new int[]{1,1,3,3}), // duplicate elements
                Arguments.of(new int[]{3,1,1,5,4,7,8,9,11,15,2,5,18,25,100,3,1,4,56,78,12,33,11,69,8,64,101,112,1}, // lots of elements
                        new int[]{1,1,1,1,2,3,3,4,4,5,5,7,8,8,9,11,11,12,15,18,25,33,56,64,69,78,100,101,112})
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void addAndRemove_MinHeap_BasicParameters(int[] numbers, int[] expected) {
        BinaryHeap<Integer> CUT = new BinaryHeap<>();

        for (Integer num : numbers) {
            CUT.add(num);
        }

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], CUT.remove());
            Assertions.assertEquals(expected.length-1-i, CUT.size());
        }
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void addAndRemove_MaxHeap_BasicParameters(int[] numbers, int[] expected) {
        BinaryHeap<Integer> CUT = new BinaryHeap<>(BinaryHeap.SortType.MAX);
        ArrayUtils.reverse(expected); // reverse the expected order (since it is MAX rather than MIN)

        for (Integer num : numbers) {
            CUT.add(num);
        }

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], CUT.remove());
            Assertions.assertEquals(expected.length-1-i, CUT.size());
        }
    }

    @Test
    public void addAndRemoveElements_MinHeap_ReturnsInOrder() {
        BinaryHeap<Integer> CUT = new BinaryHeap<>();

        CUT.add(1);
        CUT.add(2);
        CUT.add(3);
        CUT.add(4);
        CUT.add(5);

        Assertions.assertEquals(5, CUT.size());
        Assertions.assertEquals(1, CUT.remove());
        Assertions.assertEquals(2, CUT.remove());
        Assertions.assertEquals(3, CUT.remove());
        Assertions.assertEquals(4, CUT.remove());
        Assertions.assertEquals(5, CUT.remove());
        Assertions.assertEquals(0, CUT.size());
    }

    @Test
    public void addAndRemoveElements_MaxHeap_ReturnsInMaxOrder() {
        BinaryHeap<Integer> CUT = new BinaryHeap<>(BinaryHeap.SortType.MAX);

        CUT.add(5);
        CUT.add(4);
        CUT.add(3);
        CUT.add(2);
        CUT.add(1);

        Assertions.assertEquals(5, CUT.size());
        Assertions.assertEquals(5, CUT.remove());
        Assertions.assertEquals(4, CUT.remove());
        Assertions.assertEquals(3, CUT.remove());
        Assertions.assertEquals(2, CUT.remove());
        Assertions.assertEquals(1, CUT.remove());
        Assertions.assertEquals(0, CUT.size());
    }

    @Test
    public void peek_ShowsValueButDoesntRemove() {
        BinaryHeap<Integer> CUT = new BinaryHeap<>();
        CUT.add(1);
        CUT.add(2);
        CUT.add(3);
        CUT.add(4);
        CUT.add(5);

        Assertions.assertEquals(5, CUT.size());
        Assertions.assertEquals(1, CUT.peek());
        Assertions.assertEquals(5, CUT.size());
    }
}
