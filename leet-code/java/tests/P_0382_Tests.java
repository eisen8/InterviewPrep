import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0382_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (s, t, expected)
                Arguments.of("abc", "ahbgdc", true), // e1
                Arguments.of("axc", "ahbgdc", false), // e2
                Arguments.of("", "aab", true), // empty s
                Arguments.of("a", "", false), // empty t
                Arguments.of("abcd", "ab", false), // larger s
                Arguments.of("abcd", "abcd", true) // equal
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void isSubsequence_BasicParameters(String s, String t, boolean expected) {
        P_0392 CUT = new P_0392();

        boolean result  = CUT.isSubsequence(s, t);

        Assertions.assertEquals(expected, result);
    }
}