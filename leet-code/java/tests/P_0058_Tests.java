import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0058_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (string, expected)
                Arguments.of("Hello World", 5), // e1
                Arguments.of("   fly me   to   the moon  ", 4), // e2
                Arguments.of("luffy is still joyboy", 6), // e3
                Arguments.of("Boy", 3), // Single word
                Arguments.of("  Boy  ", 3), // Single word with white space
                Arguments.of("     ", 0), // all white space
                Arguments.of("", 0),  // empty
                Arguments.of(null, 0)  // null
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void lengthOfLastWord_BasicParameters(String s, int expected) {
        P_0058 CUT = new P_0058();

        int result = CUT.lengthOfLastWord(s);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void lengthOfLastWord2_BasicParameters(String s, int expected) {
        P_0058 CUT = new P_0058();

        int result = CUT.lengthOfLastWord2(s);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void lengthOfLastWord3_BasicParameters(String s, int expected) {
        P_0058 CUT = new P_0058();

        int result = CUT.lengthOfLastWord3(s);

        Assertions.assertEquals(expected, result);
    }
}