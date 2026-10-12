/*
 * LeetCode #876 — Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * Problem: Given the head of a singly linked list, return the middle
 * node (the second middle node if there are two).
 *
 * Concept link: A while-loop fits best — the slow/fast pointers stop
 * exactly when fast runs off the list, a point that depends on the
 * list's length rather than a fixed count.
 *
 * Time: O(n)    Space: O(1)
 */
class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class Q5_MiddleOfLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Solution.ListNode head = new Solution.ListNode(1);
        head.next = new Solution.ListNode(2);
        head.next.next = new Solution.ListNode(3);
        head.next.next.next = new Solution.ListNode(4);
        head.next.next.next.next = new Solution.ListNode(5);

        System.out.println("Input: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Output: " + sol.middleNode(head).val);
    }
}
