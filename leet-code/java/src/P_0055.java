import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 55. Jump Game --- https://leetcode.com/problems/jump-game/description
// See bottom for problem statement
public class P_0055 {
    /**
     * Recursively checking all paths.
     */
    public boolean canJumpOptimal(int[] nums) {
        int farthestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthestIndex) { return false; }
            farthestIndex = Math.max(farthestIndex, i + nums[i]);
        }
        return true;
    }


    /**
     * Recursively checking all paths.
     */
    public boolean canJump(int[] nums) {
        if (nums[0] >= nums.length-1) { return true; } // we can jump to the end
        if (nums[0] <= 0) { return false; } // dead end

        for (int i = 0; i < nums[0]; i++) {
            if (canJump(Arrays.copyOfRange(nums, i+1, nums.length))) { // recursively pass in a smaller subarray
                return true;
            }
        }

        return false;
    }

    /**
     * Same as above but with memoification (i.e. caching already visited indexes). Each time we explore an index fully
     * we add it to the memo so we don't have to re-explore it.
     */
    public boolean canJump2(int[] nums) {
        return canJumpMemo(nums, 0, new ArrayList<>());
    }

    private boolean canJumpMemo(int[] nums, int currentIndex, ArrayList<Integer> memo) {
        if (memo.contains(currentIndex)) { return false; } // already explored this index node
        if (nums[0] >= nums.length-1) { return true; } // we can jump to the end
        if (nums[0] <= 0) { return false; } // dead end

        for (int i = 0; i < nums[0]; i++) {
            if (canJumpMemo(Arrays.copyOfRange(nums, i+1, nums.length), currentIndex+1+i, memo)) { // recursively pass in a smaller subarray
                return true;
            }
        }
        memo.add(currentIndex);
        return false;
    }

    /**
     * Backtrack method. We start at the end and try to work out way to the beginning to see if anything could jump each step
     * along the way.
     */
    public boolean canJump3(int[] nums) {
        if (nums.length <= 1) { return true; }

        int backTrackIndex = nums.length-1; // the current index we can jump to the end to (starts from the end and works to the start)
        for (int i = 1; backTrackIndex-i >= 0; i++) { // we move i back to see if there are any indexes that can jump to the current backTrackIndex
            int jumpIndex = backTrackIndex-i;
            if (nums[jumpIndex]+jumpIndex >= backTrackIndex) { // If true we can jump to the backtrack index from the jumpIndex
                backTrackIndex = jumpIndex; // move the backtrack index forward
                i = 0; // reset i
                if (backTrackIndex == 0) {
                    return true; // we reached beginning starting from the end
                }
            }
        }

        return false;
    }

    /**
     * Greedy forward algorithm. We look ahead to the farthest we can jump in TWO jumps and always take that choice.
     */
    public boolean canJump4(int[] nums) {
        if (nums.length <= 1) { return true; }

        int currentIndex = 0;
        while (true) {
            int numJumps = nums[currentIndex];
            int bestJump = 0;

            // Check each possible double jump from the current index and find the best
            for (int i = currentIndex+numJumps; i > currentIndex; i--) { // check the farthest first jump first
                if (i >= nums.length-1) {
                    return true; // if the first jump crosses, we are done
                }

                if (i + nums[i] > bestJump) {
                    bestJump = numJumps + nums[i];
                }
            }

            currentIndex += bestJump;
            if (currentIndex >= nums.length-1) {
                return true; // if the first best jump crosses, we are done
            }

            if (bestJump <= 0) {
                return false; // Can no longer jump
            }
        }
    }
}

/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.



Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 105


*/
