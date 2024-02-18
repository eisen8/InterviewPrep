import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0121_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(new int[]{7,1,5,3,6,4}, 5), // e1
                Arguments.of(new int[]{7,6,4,3,1}, 0), // e2
                Arguments.of(new int[]{}, 0), // empty array
                Arguments.of(null, 0), // null array
                Arguments.of(new int[]{1,2,3,4,5,6,7}, 6), // all increasing
                Arguments.of(new int[]{90,89,88,89,90,100,150,60,110,40,80}, 62) // several peaks
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void maxProfit_BasicParameters(int[] prices, int expected) {
        P_0121 CUT = new P_0121();

        int result  = CUT.maxProfit(prices);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void maxProfit2_BasicParameters(int[] prices, int expected) {
        P_0121 CUT = new P_0121();

        int result  = CUT.maxProfit2(prices);

        Assertions.assertEquals(expected, result);
    }
}