import java.util.HashMap;
import java.util.Map;

// 169. Majority Element --- https://leetcode.com/problems/majority-element/description
// See bottom for problem statement
public class P_0169 {

    /**
     * Keep track of a counter and the current majority element. Add to the counter for each matching element or subtract
     * if the element doesn't match. We switch the majority element if the count drops below 0.
     * Since the Majority Element is guaranteed to occupy more than n/2 spots it will always
     * come out by the end.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Nums must have at least 1 element in it");
        }

        int currMajNum = nums[0];
        int counter = 1;
        for (int i = 1; i <nums.length; i++) {
            if (nums[i] == currMajNum) {
                counter++;
            } else {
                counter--;
                if (counter < 0) { // swap majority num
                    counter = 1;
                    currMajNum = nums[i];
                }
            }
        }

        return currMajNum;
    }

    /**
     * Keep track of each number and its count in a hashmap.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Nums must have at least 1 element in it");
        }

        Map<Integer, Integer> counts = new HashMap<>(); // Map of the <Element, CurrentCount>
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int majorityLength = nums.length/2;
        for (Map.Entry<Integer, Integer> count : counts.entrySet()) {
            if (count.getValue() > majorityLength) {
                return count.getKey();
            }
        }

        throw new IllegalArgumentException("Nums must have a majority element occupying more than half the size");
    }
}

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2



Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?

*/
