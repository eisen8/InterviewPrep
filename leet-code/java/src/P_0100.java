import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

// 100. Same Tree--- https://leetcode.com/problems/same-tree/description
// See bottom for problem statement
public class P_0100 {

    /**
     * Recursively compare
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null & q == null) { return true; }
        if (p == null || q == null) { return false; }
        if (p.val != q.val) { return false; }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Queue/stack based solution
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        Queue<QueueFrame> queue = new ArrayDeque<>(); // could also use a stack here
        queue.add(new QueueFrame(p, q));

        while (!queue.isEmpty()) {
            QueueFrame curr = queue.remove();
            if (!(curr.a == null && curr.b == null)) { // if both are null move on
                if (curr.a == null || curr.b == null) { return false; } // if only 1 is null, they are not equal
                if (curr.a.val != curr.b.val) { return false; }

                queue.add(new QueueFrame(curr.a.left, curr.b.left));
                queue.add(new QueueFrame(curr.a.right, curr.b.right));
            }
        }

        return true;
    }

    private class QueueFrame {
        TreeNode a;
        TreeNode b;

        public QueueFrame(TreeNode a, TreeNode b) {
            this.a = a;
            this.b = b;
        }
    }
}

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/
