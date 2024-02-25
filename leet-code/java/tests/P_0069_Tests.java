import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0069_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (x, expected)
                Arguments.of(4, 2), // e1
                Arguments.of(8, 2), // e2
                Arguments.of(0, 0), // zero
                Arguments.of(1, 1), // one
                Arguments.of(69, 8),
                Arguments.of(64, 8),
                Arguments.of(63, 7),
                Arguments.of(81, 9),
                Arguments.of(2147395599, 46339)
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void mySqrt_BasicParameters(int x, int expected) {
        P_0069 CUT = new P_0069();

        int result = CUT.mySqrt(x);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void mySqrt2_BasicParameters(int x, int expected) {
        P_0069 CUT = new P_0069();

        int result = CUT.mySqrt2(x);

        Assertions.assertEquals(expected, result);
    }
}