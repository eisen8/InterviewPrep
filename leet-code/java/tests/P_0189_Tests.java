import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0189_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, k, expected)
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}), // e1
                Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}), // e2
                Arguments.of(new int[]{1}, 3, new int[]{1}), // 1 element
                Arguments.of(new int[]{1, 2}, 1, new int[]{2, 1}), // 2 elements
                Arguments.of(new int[]{1, 4, 5, 6}, 0, new int[]{1, 4, 5, 6}), // 0 k
                Arguments.of(new int[]{1, 4, 5, 6}, -1, new int[]{1, 4, 5, 6}), // negative k
                Arguments.of(new int[]{1, 4, 5, 6}, 4, new int[]{1, 4, 5, 6}), // full loop
                Arguments.of(new int[]{1, 4, 5, 6}, 4000000, new int[]{1, 4, 5, 6}), // many loops
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{4, 5, 1, 2, 3}) // replace2 comment example
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void rotate_BasicParameters(int[] nums, int k, int[] expectedResult) {
        P_0189 CUT = new P_0189();

        CUT.rotate(nums, k);

        Assertions.assertArrayEquals(expectedResult, nums);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void rotate2_BasicParameters(int[] nums, int k, int[] expectedResult) {
        P_0189 CUT = new P_0189();

        CUT.rotate2(nums, k);

        Assertions.assertArrayEquals(expectedResult, nums);
    }

}