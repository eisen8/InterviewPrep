// 35. Search Insert Position --- https://leetcode.com/problems/search-insert-position/description
// See bottom for problem statement
public class P_0035 {

    /**
     * Standard binary search looking at middle index each time.
     * Time complexity: O(log(n))
     * Space complexity: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            int middle = start+((end-start)/2);

            if (nums[middle] == target) { return middle; }

            if (nums[middle] < target) {
                start = middle+1;
            } else if (nums[middle] > target) {
                end = middle-1;
            }
        }

        if (nums[start] >= target) {
            return start;
        } else {
            return start+1;
        }
    }

    /**
     * Same as above but handle edge cases at start rather than at end
     */
    public int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        // Handle outside edge cases first
        if (nums[start] > target) { return 0; }
        if (nums[end] < target) { return nums.length; }

        while (start < end) {
            int middle = start+((end-start)/2);

            if (nums[middle] == target) { return middle; }

            if (nums[middle] < target) {
                start = middle+1;
            } else if (nums[middle] > target) {
                end = middle;
            }
        }

        return start;
    }
}

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4



Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104

*/
