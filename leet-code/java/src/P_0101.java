// 101. Symmetric Tree-- https://leetcode.com/problems/symmetric-tree/description/
// See bottom for problem statement
public class P_0101 {

    /**
     * Recursively compare
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) { return true; }
        if (left == null || right == null) { return false; }
        if (left.val != right.val) { return false; }

        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/
