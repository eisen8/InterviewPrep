import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0290_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (pattern, s, expected)
                Arguments.of("abba", "dog cat cat dog", true), // e1
                Arguments.of("abba", "dog cat cat fish", false), // e2
                Arguments.of("aaaa", "dog cat cat dog", false), // e3
                Arguments.of("", "", true), // empty
                Arguments.of("a", "dog cat ", false), // mixed size
                Arguments.of("ab", "dog cat", true), // two
                Arguments.of("abbd", "dog cat cat dog", false), // reused word
                Arguments.of("abba", "dog dog dog dog", false), // reused word
                Arguments.of("aaaaaaa", "dog dog dog dog dog dog dog", true),
                Arguments.of("aaaaaaa", "dog dog dog dog dog dog dog dog", false), // too many dogs
                Arguments.of("aaaaaaaa", "dog dog dog dog dog dog dog", false) // too many a's
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void wordPattern_BasicParameters(String pattern, String s, boolean expected) {
        P_0290 CUT = new P_0290();

        boolean result  = CUT.wordPattern(pattern, s);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void wordPattern2_BasicParameters(String pattern, String s, boolean expected) {
        P_0290 CUT = new P_0290();

        boolean result  = CUT.wordPattern2(pattern, s);

        Assertions.assertEquals(expected, result);
    }
}