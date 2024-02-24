import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0055_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(new int[]{2, 3, 1, 1, 4}, true), // e1
                Arguments.of(new int[]{3, 2, 1, 0, 4}, false), // e2
                Arguments.of(new int[]{1}, true), // 1 element
                Arguments.of(new int[]{0}, true), // 1 element with a zero
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, true), // all 1s
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 0}, true), // last 0 doesn't matter
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 0, 0}, false), // last 2 are zeroes
                Arguments.of(new int[]{1, 1, 1, 1, 1, 2, 0, 0}, true), // jump the last zero
                Arguments.of(new int[]{0, 1, 1, 1, 1, 1, 1, 1}, false), // start with 0
                Arguments.of(new int[]{2, 0, 2, 0, 3, 0, 0, 1}, true), // barely able to make it
                Arguments.of(new int[]{100, 0, 0, 0, 0, 0, 0, 0}, true), // super jump
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, false), // all zeroes
                Arguments.of(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}, true) //
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void canJumpOptimal_BasicParameters(int[] nums, boolean expected) {
        P_0055 CUT = new P_0055();

        boolean result = CUT.canJumpOptimal(nums);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void canJump_BasicParameters(int[] nums, boolean expected) {
        P_0055 CUT = new P_0055();

        boolean result = CUT.canJump(nums);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void canJump2_BasicParameters(int[] nums, boolean expected) {
        P_0055 CUT = new P_0055();

        boolean result = CUT.canJump2(nums);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void canJump3_BasicParameters(int[] nums, boolean expected) {
        P_0055 CUT = new P_0055();

        boolean result = CUT.canJump3(nums);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void canJump4_BasicParameters(int[] nums, boolean expected) {
        P_0055 CUT = new P_0055();

        boolean result = CUT.canJump4(nums);

        Assertions.assertEquals(expected, result);
    }
}