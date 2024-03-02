import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0067_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of("11", "1", "100"), // e1
                Arguments.of("1010", "1011", "10101"), // e2
                Arguments.of("0", "0", "0"), // zero
                Arguments.of("1", "1", "10"), // e1
                Arguments.of("11111111111", "1", "100000000000") //
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void addBinary_BasicParameters(String s1, String s2, String expected) {
        P_0067 CUT = new P_0067();

        String result = CUT.addBinary(s1, s2);

        Assertions.assertEquals(expected, result);
    }
}