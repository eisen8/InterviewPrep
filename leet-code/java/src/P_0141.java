import java.util.HashSet;
import java.util.Set;

// 141. Linked List Cycle --- https://leetcode.com/problems/linked-list-cycle/description
// See bottom for problem statement
public class P_0141 {

    /**
     * Use a hashset to keep track of previously visited nodes. Go through the list and if we revisit a node we return false.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) { return false; }
        ListNode curr = head;
        Set<ListNode> alreadyVisited = new HashSet<>();
        while (curr.next != null) {
            if (alreadyVisited.contains(curr)) {
                return true; // revisited an old node... must be a loop
            }

            alreadyVisited.add(curr);
            curr = curr.next;
        }

        return false;
    }

    /**
     * Use two pointers (one fast and one slow) that traverse the list. If the two pointers ever point to the same node then there is a loop.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) { return false; }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            if (fastPointer == slowPointer) { // compare by reference
                return true;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.



Constraints:

    The number of the nodes in the list is in the range [0, 104].
    -105 <= Node.val <= 105
    pos is -1 or a valid index in the linked-list.



Follow up: Can you solve it using O(1) (i.e. constant) memory?

*/
