import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * Various usable methods to help with testing
 */
public class TestHelper {
    /**
     * Helper method to check if the first n ints of the two arrays are the same (in any order)
     */
    public static void assertArraysEqualInAnyOrder(int[] expected, int[] actual, int n) {
        int[] sortedExpected = Arrays.copyOf(expected, n);
        int[] sortedActual = Arrays.copyOf(actual, n);
        Arrays.sort(sortedExpected);
        Arrays.sort(sortedActual);
        Assertions.assertArrayEquals(sortedExpected, sortedActual);
    }
}
