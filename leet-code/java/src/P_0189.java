// 189. Rotate Array --- https://leetcode.com/problems/rotate-array/description
// See bottom for problem statement
public class P_0189 {

    /**
     * Create a new array. Copy over with the offset index. Then recopy back into nums.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // Remove excess loops of k
        if (nums.length == 1 || k <= 0) { return; }


        int[] newNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int newNumsIndex = (i+k)%nums.length;
            newNums[newNumsIndex] = nums[i];
        }

        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    /**
     * We can achieve this by doing 3 in-place reverses. First on the right most K elements. Then the rest of the left side.
     * Then the entire array. For example [1,2,3,4,5] with k=2 -> [1,2,3,  5,4] -> [3,2,1,  5,4] -> [4,5,1,2,3]
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length; // Remove excess loops of k
        if (nums.length == 1 || k <= 0) { return; }

        reverse(nums, nums.length - k, nums.length - 1); // reverse right k elements
        reverse(nums, 0, nums.length - k - 1); // reverse rest of left side
        reverse(nums, 0, nums.length - 1); // reverse full array
    }

    /**
     * Reverse the array from index i to index j. So [1,2,3] becomes [3,2,1]
     */
    private void reverse(int nums[], int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]



Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105



Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?


*/
