// 108. Convert Sorted Array to Binary Search Tree --- https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
// See bottom for problem statement
public class P_0108 {

    /**
     * We make the middle number in the sorted array be the root. The left child is then the middle of the left half of the array, and the right
     * is the mid of the right half of the array. We repeat this process recursively to generate the entire tree.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) { return null; }

        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) { return null; }

        int mid = start+((end-start)/2);
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(nums, start, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, end);

        return node;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() { }

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced
binary search tree.



Example 1:

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.



Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in a strictly increasing order.



*/
