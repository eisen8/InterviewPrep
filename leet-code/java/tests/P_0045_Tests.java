import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0045_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums, target, expected)
                Arguments.of(new int[]{2,3,1,1,4}, 2), // e1
                Arguments.of(new int[]{2,3,0,1,4}, 2), // e2
                Arguments.of(new int[]{1}, 0), // 1 element
                Arguments.of(new int[]{0}, 0), // 1 element with a zero
                Arguments.of(new int[]{1,1,1,1,1,1,1,1}, 7), // all 1s
                Arguments.of(new int[]{1,1,1,1,1,1,1,0}, 7), // last 0 doesn't matter
                Arguments.of(new int[]{1,1,1,1,1,2,0,0}, 6), // jump the last zero
                Arguments.of(new int[]{2,0,2,0,3,0,0,1}, 3), // barely able to make it
                Arguments.of(new int[]{100,0,0,0,0,0,0,0}, 1) // super jump
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void jump_BasicParameters(int[] nums, int expected) {
        P_0045 CUT = new P_0045();

        int result  = CUT.jump(nums);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void jump2_BasicParameters(int[] nums, int expected) {
        P_0045 CUT = new P_0045();

        int result  = CUT.jump2(nums);

        Assertions.assertEquals(expected, result);
    }
}