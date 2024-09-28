import common.TreeNode;

import java.util.Stack;

// 530. Minimum Absolute Difference in BST--- https://leetcode.com/problems/minimum-absolute-difference-in-bst/description
// See bottom for problem statement
public class P_0530 {

    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int currMinDiff = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            boolean finished = false;
            TreeNode greatestMin = currNode.left;
            TreeNode leastMax = currNode.right;

            if (greatestMin != null) {
                while (!finished) {
                    if (greatestMin.right != null) {
                        greatestMin = greatestMin.right;
                    } else {
                        finished = true;
                    }
                }

                currMinDiff = Math.min(Math.abs(currNode.val - greatestMin.val), currMinDiff);
            }

            finished = false;
            if (leastMax != null) {
                while (!finished) {
                    if (leastMax.left != null) {
                        leastMax = leastMax.left;
                    } else {
                        finished = true;
                    }
                }

                currMinDiff = Math.min(Math.abs(currNode.val - leastMax.val), currMinDiff);
            }

            if (currNode.left != null) { stack.push(currNode.left); }
            if (currNode.right != null) { stack.push(currNode.right); }
        }

        return currMinDiff;
    }
}

/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.



Example 1:

Input: root = [4,2,6,1,3]
Output: 1

Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1



Constraints:

    The number of nodes in the tree is in the range [2, 104].
    0 <= Node.val <= 105



Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

*/
