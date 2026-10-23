/*
 * Advanced 9: Check whether a linked list is a palindrome in O(n) time, O(1) space.
 * Find the middle, reverse the second half, compare, then restore the list.
 */
public class Q9_IsPalindrome {
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = Q6_FindMiddle.middle(head);
        Node secondHalf = Q5_ReverseList.reverse(mid);

        boolean result = true;
        Node p1 = head, p2 = secondHalf;
        while (p2 != null) {
            if (p1.data != p2.data) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        Q5_ReverseList.reverse(secondHalf); // restore the original list
        return result;
    }

    public static void main(String[] args) {
        Node[] lists = {
            ListUtil.fromArray(1, 2, 3, 2, 1),
            ListUtil.fromArray(1, 2, 2, 1),
            ListUtil.fromArray(1, 2, 3, 4),
            ListUtil.fromArray(7),
        };
        for (Node list : lists) {
            String before = ListUtil.toString(list);
            System.out.println(before + " palindrome: " + isPalindrome(list));
            if (!before.equals(ListUtil.toString(list))) {
                System.out.println("  ERROR: list was not restored");
            }
        }
    }
}
