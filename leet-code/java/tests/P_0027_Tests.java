import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0027_Tests {

    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, expectedNums, val)
                Arguments.of(new int[]{3, 2, 2, 3}, new int[]{2, 2}, 3), // e1
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, new int[]{0, 1, 3, 0, 4}, 2), // e2
                Arguments.of(new int[]{3, 3, 3, 3}, new int[]{}, 3), // all val
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, 5) // no value
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeElement_BasicParameters(int[] nums, int[] expectedNums, int val) {
        P_0027 CUT = new P_0027();

        int result = CUT.removeElement(nums, val);

        Assertions.assertEquals(expectedNums.length, result);
        TestHelper.assertArraysEqualInAnyOrder(expectedNums, nums, expectedNums.length);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeElement2_BasicParameters(int[] nums, int[] expectedNums, int val) {
        P_0027 CUT = new P_0027();

        int result = CUT.removeElement2(nums, val);

        Assertions.assertEquals(expectedNums.length, result);
        TestHelper.assertArraysEqualInAnyOrder(expectedNums, nums, expectedNums.length);
    }
}