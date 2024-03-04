// 222. Count Complete Tree Nodes --- https://leetcode.com/problems/count-complete-tree-nodes/description
// See bottom for problem statement
public class P_0222 {


    /**
     * Standard recursion brute force count
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int countNodes(TreeNode root) {
        if (root == null) { return 0; }
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    /**
     * Since it is a complete binary tree, we use the height of the left side compared to the height of the right side to see if it is perfect.
     * A perfect binary tree will have total nodes equivalent to 2^height-1. If it isn't a perfect tree we check if the subtrees on the left and right
     * node are perfect binary trees and recursively repeat this process.
     * Time complexity: O(log(n)^2)
     * Space complexity: O(1)
     */
    public int countNodes2(TreeNode root) {
        if (root == null) { return 0; }
        int lHeight = 0;
        int rHeight = 0;
        TreeNode heightNode = root;

        // Calculate left tree height
        while (heightNode != null) {
            heightNode = heightNode.left;
            lHeight++;
        }


        // Calculate right tree height
        heightNode = root;
        while (heightNode != null) {
            heightNode = heightNode.right;
            rHeight++;
        }

        if (lHeight == rHeight) {
            return (int) (Math.pow(2, lHeight)-1); // Perfect Binary Tree: Total nodes is 2^height-1.
        }

        return countNodes2(root.left)+countNodes2(root.right)+1; // Recursively sum on the left and right children.
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
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.



Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:

Input: root = []
Output: 0

Example 3:

Input: root = [1]
Output: 1



Constraints:

    The number of nodes in the tree is in the range [0, 5 * 104].
    0 <= Node.val <= 5 * 104
    The tree is guaranteed to be complete.



*/
