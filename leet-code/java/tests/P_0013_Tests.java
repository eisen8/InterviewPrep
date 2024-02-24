import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0013_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of("III", 3), // e1
                Arguments.of("LVIII", 58), // e2
                Arguments.of("MCMXCIV", 1994), // e3
                Arguments.of("I", 1), // 1
                Arguments.of("", 0), // 0
                Arguments.of(null, 0), // null
                Arguments.of("MCMXCIX", 1999), // 1999
                Arguments.of("MCDXLIX", 1449) // 1449
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void romanToInt_BasicParameters(String s, int expected) {
        P_0013 CUT = new P_0013();

        int result = CUT.romanToInt(s);

        Assertions.assertEquals(expected, result);
    }
}