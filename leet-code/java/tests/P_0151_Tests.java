import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0151_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (s, expected)
                Arguments.of("the sky is blue", "blue is sky the"), // e1
                Arguments.of("  hello world  ", "world hello"), // e2
                Arguments.of("a good    example", "example good a"), // e3
                Arguments.of("                 ", ""),
                Arguments.of("", ""),
                Arguments.of(" a  good  test  example  yes  ", "yes example test good a")
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void reverseWords_BasicParameters(String s, String expected) {
        P_0151 CUT = new P_0151();

        String result  = CUT.reverseWords(s);

        Assertions.assertEquals(expected, result);
    }
}