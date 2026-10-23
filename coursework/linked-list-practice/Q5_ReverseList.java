/*
 * Intermediate 5: Reverse a linked list by flipping each next pointer.
 * Also used by Q9 (palindrome check).
 */
public class Q5_ReverseList {
    static Node reverse(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = ListUtil.fromArray(1, 2, 3, 4, 5);
        System.out.println("Original: " + ListUtil.toString(head));
        head = reverse(head);
        System.out.println("Reversed: " + ListUtil.toString(head));
        System.out.println("Reversed empty: " + ListUtil.toString(reverse(null)));
        System.out.println("Reversed single: " + ListUtil.toString(reverse(ListUtil.fromArray(9))));
    }
}
