package misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> fibBasicParameters() {
        return Stream.of(
                Arguments.of(-1, 0), // (n , expectedValue)
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8),
                Arguments.of(7, 13),
                Arguments.of(8, 21),
                Arguments.of(9, 34),
                Arguments.of(10, 55),
                Arguments.of(30, 832040)
        );
    }


    @ParameterizedTest
    @MethodSource("fibBasicParameters")
    public void RecursiveFib_FibBasicParameters(int n, int expected) {
        Fibonacci CUT = new Fibonacci();

        int result = CUT.recursiveFib(n);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("fibBasicParameters")
    public void CachedRecursiveFib_FibBasicParameters(int n, int expected) {
        Fibonacci CUT = new Fibonacci();

        int result = CUT.cachedRecursiveFib(n);

        assertEquals(expected, result);
    }

    @Test
    public void CachedRecursiveFib_ResizeCache() {
        Fibonacci CUT = new Fibonacci(5);

        int result = CUT.cachedRecursiveFib(40);

        assertEquals(102334155, result);
    }

    @ParameterizedTest
    @MethodSource("fibBasicParameters")
    public void IterativeFib_FibBasicParameters(int n, int expected) {
        Fibonacci CUT = new Fibonacci();

        int result = CUT.iterativeFib(n);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("fibBasicParameters")
    public void IterativeStackFib_FibBasicParameters(int n, int expected) {
        Fibonacci CUT = new Fibonacci();

        int result = CUT.iterativeStackFib(n);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("fibBasicParameters")
    public void IterativeStackFib2_FibBasicParameters(int n, int expected) {
        Fibonacci CUT = new Fibonacci();

        int result = CUT.iterativeStackFib2(n);

        assertEquals(expected, result);
    }
}
