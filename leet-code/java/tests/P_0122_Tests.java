import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0122_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(new int[]{7,1,5,3,6,4}, 7), // e1
                Arguments.of(new int[]{1,2,3,4,5}, 4), // e2
                Arguments.of(new int[]{7,6,4,3,1}, 0), // e3
                Arguments.of(new int[]{7}, 0), // 1 day
                Arguments.of(new int[]{}, 0), // no days
                Arguments.of(null, 0) // null
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void maxProfit_BasicParameters(int[] nums, int expectedResult) {
        P_0122 CUT = new P_0122();

        int result  = CUT.maxProfit(nums);

        Assertions.assertEquals(expectedResult, result);

    }
}