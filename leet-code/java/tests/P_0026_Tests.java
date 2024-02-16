import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class P_0026_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, expectedNums, expectedResult)
                Arguments.of(new int[]{1,1,2}, new int[]{1,2}, 2), // e1
                Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, new int[]{0,1,2,3,4}, 5), // e2
                Arguments.of(new int[]{}, new int[]{}, 0), // empty
                Arguments.of(new int[]{1}, new int[]{1}, 1), // 1 value
                Arguments.of(new int[]{0,1,2,3,4,5,6,7}, new int[]{0,1,2,3,4,5,6,7}, 8) // nu duplicates
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeDuplicates_BasicParameters(int[] nums, int[] expectedNums, int expectedResult) {
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates(nums);

        Assertions.assertEquals(expectedResult, result);
        Assertions.assertArrayEquals(expectedNums, Arrays.copyOfRange(nums, 0, expectedNums.length));
    }

    @Test
    public void removeDuplicates_nullArray() {
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates(null);

        Assertions.assertEquals(0, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeDuplicates2_BasicParameters(int[] nums, int[] expectedNums, int expectedResult) {
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates2(nums);

        Assertions.assertEquals(expectedResult, result);
        Assertions.assertArrayEquals(expectedNums, Arrays.copyOfRange(nums, 0, expectedNums.length));
    }

    @Test
    public void removeDuplicates2_nullArray() {
        P_0026 CUT = new P_0026();

        int result  = CUT.removeDuplicates2(null);

        Assertions.assertEquals(0, result);
    }
}