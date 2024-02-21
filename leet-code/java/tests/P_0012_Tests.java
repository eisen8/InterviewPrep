import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0012_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(3, "III"), // e1
                Arguments.of(58, "LVIII"), // e2
                Arguments.of(1994, "MCMXCIV", 1994), // e3
                Arguments.of(1, "I"), // 1
                Arguments.of(0, ""), // 0
                Arguments.of(1999, "MCMXCIX"), // 1999
                Arguments.of(1449, "MCDXLIX"), // 1449
                Arguments.of(1444, "MCDXLIV"), // 1444
                Arguments.of(3999, "MMMCMXCIX") // 3999
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void intToRoman_BasicParameters(int num, String expected) {
        P_0012 CUT = new P_0012();

        String result  = CUT.intToRoman(num);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void intToRoman2_BasicParameters(int num, String expected) {
        P_0012 CUT = new P_0012();

        String result  = CUT.intToRoman2(num);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void intToRoman3_BasicParameters(int num, String expected) {
        P_0012 CUT = new P_0012();

        String result  = CUT.intToRoman3(num);

        Assertions.assertEquals(expected, result);
    }
}