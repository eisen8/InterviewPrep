import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0014_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"), // e1
                Arguments.of(new String[]{"dog", "racecar", "car"}, ""), // e2
                Arguments.of(new String[]{""}, ""), // empty
                Arguments.of(new String[]{"dog"}, "dog"), // 1 string
                Arguments.of(new String[]{"dog", "dog"}, "dog"), // 2 string duplicate
                Arguments.of(new String[]{"dogmeat", "dog"}, "dog") // 2 string
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void removeDuplicates_BasicParameters(String[] strs, String expected) {
        P_0014 CUT = new P_0014();

        String result = CUT.longestCommonPrefix(strs);

        Assertions.assertEquals(expected, result);
    }
}