import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 45. Jump Game II --- https://leetcode.com/problems/jump-game-ii/description
// See bottom for problem statement
public class P_0045 {
    /**
     * Backtrack method. We start at the end and try to work out way to the beginning to see if anything could jump each step
     * along the way.
     */
    public int jump(int[] nums) {
        if (nums.length <= 1) { return 0; }
        int numJumps = 0;
        int backTrackIndex = nums.length-1; // the current index we can jump to the end to (starts from the end and works to the start)
        int largestNextJumpIndex = backTrackIndex; // keeps track of the largest jump we can do to the next spot

        while (backTrackIndex > 0) {
            for (int i = 1; backTrackIndex - i >= 0; i++) { // we move i back to see if there are any indexes that can jump to the current backTrackIndex
                int nextJumpIndex = backTrackIndex - i;
                if (nums[nextJumpIndex] + nextJumpIndex >= backTrackIndex) { // If true we can jump to the backtrack index from the jumpIndex
                    largestNextJumpIndex = nextJumpIndex;
                }
            }

            backTrackIndex = largestNextJumpIndex; // move the backtrack index forward with the largest jump
            numJumps++;
        }

        return numJumps;
    }


    /**
     * Recursive using memoification (i.e. caching already visited indexes). Each time we explore an index fully
     * we add it to the memo so we don't have to re-explore it.
     */
    public int jump2(int[] nums) {
        if (nums.length <= 1) { return 0; };

        return jumpMemo(nums, 0, new HashMap<>());
    }

    private Integer jumpMemo(int[] nums, int currentIndex, HashMap<Integer,Integer> memo) {
        if (memo.containsKey(currentIndex)) { return memo.get(currentIndex); } // already explored this index node
        if (nums[0] >= nums.length-1) { return 1; } // we can jump to the end
         if (nums[0] <= 0) { return null; } // dead end

        Integer minSubJumps = null;
        for (int i = 0; i < nums[0]; i++) {
            Integer result = jumpMemo(Arrays.copyOfRange(nums, i+1, nums.length), currentIndex+1+i, memo);
            if (minSubJumps == null) {
                minSubJumps = result;
            } else if (result != null && result < minSubJumps) {
                minSubJumps = result;
            }
        }

        if (minSubJumps != null) {
            minSubJumps++;
        }
        memo.put(currentIndex, minSubJumps);
        return minSubJumps;
    }
}

/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

    0 <= j <= nums[i] and
    i + j < n

Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2



Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 1000
    It's guaranteed that you can reach nums[n - 1].



*/
