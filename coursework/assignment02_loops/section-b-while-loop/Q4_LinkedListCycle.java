/*
 * LeetCode #141 — Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Problem: Given the head of a linked list, determine if it has a cycle.
 *
 * Concept link: A while-loop fits best — Floyd's slow/fast pointers run
 * for an unknown number of steps that depends entirely on where (or
 * whether) a cycle exists in the list.
 *
 * Time: O(n)    Space: O(1)
 */
class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

public class Q4_LinkedListCycle {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Solution.ListNode a = new Solution.ListNode(3);
        Solution.ListNode b = new Solution.ListNode(2);
        Solution.ListNode c = new Solution.ListNode(0);
        Solution.ListNode d = new Solution.ListNode(-4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b; // creates a cycle back into b

        System.out.println("Input: 3 -> 2 -> 0 -> -4 -> (back to 2)");
        System.out.println("Output: " + sol.hasCycle(a));
    }
}
