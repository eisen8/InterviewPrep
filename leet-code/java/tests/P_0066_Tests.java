import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0066_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}), // e1
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}), // e2
                Arguments.of(new int[]{9}, new int[]{1, 0}), // e3
                Arguments.of(new int[]{9, 9}, new int[]{1, 0, 0}), // 99
                Arguments.of(new int[]{9, 8}, new int[]{9, 9}), // 98
                Arguments.of(new int[]{4, 9}, new int[]{5, 0}), // 49
                Arguments.of(new int[]{0}, new int[]{1}), // 0
                Arguments.of(new int[]{1}, new int[]{2}) // 1
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void plusOne_BasicParameters(int[] digits, int[] expected) {
        P_0066 CUT = new P_0066();

        int[] result = CUT.plusOne(digits);

        Assertions.assertArrayEquals(expected, result);
    }
}