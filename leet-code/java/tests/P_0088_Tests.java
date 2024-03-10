import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class P_0088_Tests {
    /**
     * Parameters for basic tests.
     */
    private static Stream<Arguments> basicTestParameters() {
        return Stream.of( // (nums1, n, nums2, expected)
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, new int[]{1, 2, 2, 3, 5, 6}), // e1
                Arguments.of(new int[]{1}, 1, new int[]{}, new int[]{1}), // e2
                Arguments.of(new int[]{0}, 0, new int[]{1}, new int[]{1}) // e3
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void merge_BasicParameters(int[] nums1, int n, int[] nums2, int[] expected) {
        P_0088 CUT = new P_0088();

        CUT.merge(nums1, n, nums2, nums2.length);

        Assertions.assertArrayEquals(expected, nums1);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void merge2_BasicParameters(int[] nums1, int n, int[] nums2, int[] expected) {
        P_0088 CUT = new P_0088();

        CUT.merge2(nums1, n, nums2, nums2.length);

        Assertions.assertArrayEquals(expected, nums1);
    }

    @ParameterizedTest
    @MethodSource("basicTestParameters")
    public void merge3_BasicParameters(int[] nums1, int n, int[] nums2, int[] expected) {
        P_0088 CUT = new P_0088();

        CUT.merge3(nums1, n, nums2, nums2.length);

        Assertions.assertArrayEquals(expected, nums1);
    }
}