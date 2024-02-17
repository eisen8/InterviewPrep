import java.util.*;

// 1. Two Sum --- https://leetcode.com/problems/two-sum/description/
// See bottom for problem statement
public class P_0001 {

    /**
     * Double for loop checking all combinations of two sums
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{}; // no solution found
    }

    /**
     * Uses a hashmap. We can iterate through the array one time checking if the needed value is in the hashmap.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // (number, index)
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (map.containsKey(needed)) {
                return new int[] {map.get(needed), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{}; // no solution found
    }

    /**
     * Sort the array first. Then do two pointers (one starting at the start and one at the end). If the sum is too large
     * move the end pointer down 1, if too small move the starting pointer up one.
     * Time complexity: O(nlog(n))
     * Space complexity: O(1)
     */
    public int[] twoSum3(int[] nums, int target) {
        int startPointer = 0;
        int endPointer = nums.length-1;
        int[] numsClone = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsClone);

        while (startPointer < endPointer) {
            int result = numsClone[startPointer] + numsClone[endPointer];
            if (result == target) {
                return getIndexesOf(nums, numsClone[startPointer], numsClone[endPointer]);
            } else if (result > target) {
                endPointer--;
            } else {
                startPointer++;
            }
        }

        return new int[]{}; // no solution found
    }

    private int[] getIndexesOf(int[] nums, int a, int b) {
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                indexes[0] = i;
            } else if (nums[i] == b) {
                indexes[1] = i;
            }
        }

        return indexes;
    }
}

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]



Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/
