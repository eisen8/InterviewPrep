import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0125_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (s, expected)
                Arguments.of("A man, a plan, a canal: Panama", true), // e1
                Arguments.of("race a car", false), // e2
                Arguments.of(" ", true), // e3
                Arguments.of("0P", false), // numeric false
                Arguments.of("0P0", true) // numeric true
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void isPalindrome_BasicParameters(String s, boolean expected) {
        P_0125 CUT = new P_0125();

        boolean result = CUT.isPalindrome(s);

        Assertions.assertEquals(expected, result);
    }
}