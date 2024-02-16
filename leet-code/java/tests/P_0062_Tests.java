import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0062_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (m, n, expected)
                Arguments.of(3, 7, 28), // e1
                Arguments.of(3, 2, 3), // e2
                Arguments.of(1, 1, 1),
                Arguments.of(0, 1, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(1, 0, 0),
                Arguments.of(2, 2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void uniquePaths_BasicParameters(int m, int n, int expected) {
        P_0062 CUT = new P_0062();

        int result  = CUT.uniquePaths(m, n);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void uniquePathsWithCache_BasicParameters(int m, int n, int expected) {
        P_0062 CUT = new P_0062();

        int result  = CUT.uniquePathsWithCache(m, n);

        Assertions.assertEquals(expected, result);
    }

}