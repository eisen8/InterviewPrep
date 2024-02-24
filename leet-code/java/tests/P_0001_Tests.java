import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0001_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}), // e1
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}), // e2
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}) // e3
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeDuplicates_BasicParameters(int[] nums, int target, int[] expectedResult) {
        P_0001 CUT = new P_0001();

        int[] result = CUT.twoSum(nums, target);

        TestHelper.assertArraysEqualInAnyOrder(result, expectedResult, expectedResult.length);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeDuplicates2_BasicParameters(int[] nums, int target, int[] expectedResult) {
        P_0001 CUT = new P_0001();

        int[] result = CUT.twoSum2(nums, target);

        TestHelper.assertArraysEqualInAnyOrder(result, expectedResult, expectedResult.length);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeDuplicates3_BasicParameters(int[] nums, int target, int[] expectedResult) {
        P_0001 CUT = new P_0001();

        int[] result = CUT.twoSum3(nums, target);

        TestHelper.assertArraysEqualInAnyOrder(result, expectedResult, expectedResult.length);
    }
}