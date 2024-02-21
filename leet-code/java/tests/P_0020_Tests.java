import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0020_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of("()", true), // e1
                Arguments.of("()[]{}", true), // e2
                Arguments.of("(]", false), // e3
                Arguments.of("[}]", false), // invalid }
                Arguments.of("{)()()", false), //invalid )
                Arguments.of("((", false) // only opens
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void isValid_BasicParameters(String s, boolean expected) {
        P_0020 CUT = new P_0020();

        boolean result  = CUT.isValid(s);

        Assertions.assertEquals(expected, result);
    }
}