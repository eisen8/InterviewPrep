import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0136_Tests {

    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, expectedNums, val)
                Arguments.of(new int[]{2, 2, 1}, 1), // e1
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4), // e2
                Arguments.of(new int[]{1}, 1) // e3
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void singleNumber_BasicParameters(int[] nums, int expected) {
        P_0136 CUT = new P_0136();

        int result = CUT.singleNumber(nums);

        Assertions.assertEquals(expected, result);
    }
}