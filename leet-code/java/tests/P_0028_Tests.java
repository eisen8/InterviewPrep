import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0028_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of("sadbutsad", "sad", 0), // e1
                Arguments.of("leetcode", "leeto", -1), // e2
                Arguments.of("", "leet", -1), // no haystack
                Arguments.of("leetcode", "", -1), // no needle
                Arguments.of(null, "leet", -1), // null haystack
                Arguments.of("leetcode", null, -1), // null needle
                Arguments.of("ouihasdjkfui", "fui", 9), // needle at end
                Arguments.of("leetcode", "coders", -1), // needle close to end but not quite
                Arguments.of("leetcode", "leetcodeiscool", -1) // needle longer than haystack
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void strStr_BasicParameters(String haystack, String needle, int expected) {
        P_0028 CUT = new P_0028();

        int result = CUT.strStr(haystack, needle);

        Assertions.assertEquals(expected, result);
    }
}