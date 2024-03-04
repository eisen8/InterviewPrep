import common.TreeNode;

import java.util.Stack;

// 104. Maximum Depth of Binary Tree --- https://leetcode.com/problems/maximum-depth-of-binary-tree/description
// See bottom for problem statement
public class P_0104 {
    /**
     * Recursively go through the tree counting the depths
     */
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int currentDepth) {
        if (root == null) { return currentDepth; }
        currentDepth++;

        return Math.max(maxDepth(root.left, currentDepth), maxDepth(root.right, currentDepth));
    }

    /**
     * Same as above but with a stack instead of recursion
     */
    public int maxDepth2(TreeNode root) {
        Stack<StackFrame> stack = new Stack<>();
        stack.push(new StackFrame(root, 0));

        int maxDepth = 0;

        while (!stack.isEmpty()) {
            StackFrame curr = stack.pop();
            if (curr.node != null) {
                int currDepth = curr.currentDepth+1;
                if (currDepth > maxDepth) {
                    maxDepth = currDepth;
                }

                // Add children to stack
                stack.push(new StackFrame(curr.node.left, currDepth));
                stack.push(new StackFrame(curr.node.right, currDepth));
            }
        }

        return maxDepth;
    }

    private class StackFrame {
        TreeNode node;
        int currentDepth;

        public StackFrame(TreeNode node, int currentDepth) {
            this.node = node;
            this.currentDepth = currentDepth;
        }

    }
}

/*
Given the root of a binary tree, invert the tree, and return its root.
*/
