import java.util.HashSet;
import java.util.Set;

// 219. Contains Duplicate II --- https://leetcode.com/problems/contains-duplicate-ii/description
// See bottom for problem statement
public class P_0219 {

    /**
     * Use a hashset to keep track of the last K numbers we have seen as we traverse the nums array.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i =0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
}

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false



Constraints:

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
    0 <= k <= 105


*/
