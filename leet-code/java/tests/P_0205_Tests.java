import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0205_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of("egg", "add", true), // e1
                Arguments.of("foo", "bar", false), // e2
                Arguments.of("paper", "title", true), // e3
                Arguments.of("", "", true), // empty
                Arguments.of("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz", true), // equivalent
                Arguments.of("aaa", "abc", false), //
                Arguments.of("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba", true), // reversed
                Arguments.of("bbbaaaba", "aaabbbba", false),
                Arguments.of("badc", "baba", false)
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void isIsomorphic_BasicParameters(String s, String t, boolean expected) {
        P_0205 CUT = new P_0205();

        boolean result = CUT.isIsomorphic(s, t);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void isIsomorphic2_BasicParameters(String s, String t, boolean expected) {
        P_0205 CUT = new P_0205();

        boolean result = CUT.isIsomorphic2(s, t);

        Assertions.assertEquals(expected, result);
    }
}