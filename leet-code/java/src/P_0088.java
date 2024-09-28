import java.util.Arrays;

// 88. Merge Sorted Array --- https://leetcode.com/problems/merge-sorted-array/description
// See bottom for problem statement
public class P_0088 {
    /**
     * Simply copy nums2 to the end of nums1 and re-sort.
     * Time complexity: O((m+n)*log(m+n))
     * Space complexity: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) { System.arraycopy(nums2, 0, nums1, m, n); }
        Arrays.sort(nums1);
    }

    /**
     * Two pointers method copying into a buffer. Then copy the buffer back into nums1.
     * Time complexity: O(n+m)
     * Space complexity: O(n+m)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] buffer = new int[m+n];

        // Copy into buffer.
        for (int i = 0; i < m+n; i++) {
            if (p1 == m) { // p1 is finished... rest come from p2
                buffer[i] = nums2[p2];
                p2++;
            } else if (p2 == n) { // p2 is finished... rest come from p1
                buffer[i] = nums1[p1];
                p1++;
            } else if (nums1[p1] <= nums2[p2]) {
                buffer[i] = nums1[p1];
                p1++;
            } else {
                buffer[i] = nums2[p2];
                p2++;
            }
        }

        // Copy buffer into nums1
        System.arraycopy(buffer, 0, nums1, 0, m+n);
    }

    /**
     * Two pointer methods but inline. Use two pointers at the end of both m and nums2 to choose the largest value to put at the end of nums1. Work through both
     * sub arrays.
     * Time complexity: O(n+m)
     * Space complexity: O(1)
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1; // pointer to end of nums1
        int p2 = n-1; // pointer to end of nums2

        for (int i = m+n-1; i >= 0; i--) {
            if (p2 == -1) { // p2 is finished... rest come from p1
                nums1[i] = nums1[p1];
                p1--;
            } else if (p1 == -1) { // p1 is finished... rest come from p2
                nums1[i] = nums2[p2];
                p2--;
            } else if (nums1[p1] >= nums2[p2]) { // p1 is larger
                nums1[i] = nums1[p1];
                p1--;
            } else { // p2 is larger
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }
}

/*  88. Merge Sorted Array

    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing
    the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate
    this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n
    elements are set to 0 and should be ignored. nums2 has a length of n.

    Example 1:

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
    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.



    Constraints:

    nums1.length == m + n
    nums2.length == n
        0 <= m, n <= 200
            1 <= m + n <= 200
            -109 <= nums1[i], nums2[j] <= 109



    Follow up: Can you come up with an algorithm that runs in O(m + n) time?
*/