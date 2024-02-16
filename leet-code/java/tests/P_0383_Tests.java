import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0383_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (ransom, magazine, expected)
                Arguments.of("a", "b", false), // e1
                Arguments.of("aa", "ab", false), // e2
                Arguments.of("aa", "aab", true) // e3
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void canConstruct_BasicParameters(String ransom, String magazine, boolean expected) {
        P_0383 CUT = new P_0383();

        boolean result  = CUT.canConstruct(ransom, magazine);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void canConstruct2_BasicParameters(String ransom, String magazine, boolean expected) {
        P_0383 CUT = new P_0383();

        boolean result  = CUT.canConstruct2(ransom, magazine);

        Assertions.assertEquals(expected, result);
    }
}