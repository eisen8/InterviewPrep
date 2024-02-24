import java.util.LinkedHashSet;
import java.util.Set;

// 26. Remove Duplicates from Sorted Array --- https://leetcode.com/problems/remove-duplicates-from-sorted-array/description
// See bottom for problem statement
public class P_0026 {

    /**
     * This solution uses 1 pointer to keep track of where the next nonduplicate should be. As we go through the array
     * we find the next nonduplicate (using lookback) and swap it to where the pointer is.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) { // non-duplicate
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    /**
     * This solution adds nums into a set (removing duplicates) and then copies the set back over.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        Set<Integer> nonDup = new LinkedHashSet<>();
        for (int num : nums) { // Add to set
            nonDup.add(num);
        }

        int index = 0;
        for (Integer num : nonDup) { // Copy set back over
            nums[index] = num;
            index++;
        }

        return nonDup.size();
    }
}

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
        }

If all assertions pass, then your solution will be accepted.



        Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).



Constraints:

        1 <= nums.length <= 3 * 104
        -100 <= nums[i] <= 100
nums is sorted in non-decreasing order.



*/
