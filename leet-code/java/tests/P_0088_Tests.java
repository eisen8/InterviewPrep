import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P_0088_Tests {
    @Test
    public void merge_e1() {
        P_0088 CUT = new P_0088();
        int[] n1 = {1, 2, 3, 0, 0, 0};
        int[] n2 = {2, 5, 6};
        int[] expected = {1, 2, 2, 3, 5, 6};

        CUT.merge(n1, 3, n2, 3);

        Assertions.assertArrayEquals(expected, n1);
    }

    @Test
    public void merge_e2() {
        P_0088 CUT = new P_0088();
        int[] n1 = {1};
        int[] n2 = {};
        int[] expected = {1};

        CUT.merge(n1, 1, n2, 0);

        Assertions.assertArrayEquals(expected, n1);
    }

    @Test
    public void merge_e3() {
        P_0088 CUT = new P_0088();
        int[] n1 = {0};
        int[] n2 = {1};
        int[] expected = {1};

        CUT.merge(n1, 0, n2, 1);

        Assertions.assertArrayEquals(expected, n1);
    }

/*  Example 1:

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    Example 2:

    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]
    Explanation: The arrays we are merging are [1] and [].
    The result of the merge is [1].

    Example 3:

    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
    Output: [1]
    Explanation: The arrays we are merging are [] and [1].
    The result of the merge is [1].
    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.*/
}