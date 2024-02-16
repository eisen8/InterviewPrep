import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0169_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, expected)
                Arguments.of(new int[]{3,2,3}, 3), // e1
                Arguments.of(new int[]{2,2,1,1,1,2,2}, 2), // e2
                Arguments.of(new int[]{5}, 5), // one element
                Arguments.of(new int[]{5, 5}, 5) // two duplicate elements
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeDuplicates_BasicParameters(int[] nums, int expected) {
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement(nums);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeDuplicates2_BasicParameters(int[] nums, int expected) {
        P_0169 CUT = new P_0169();

        int result  = CUT.majorityElement2(nums);

        Assertions.assertEquals(expected, result);
    }

}