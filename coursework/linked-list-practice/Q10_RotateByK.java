/*
 * Advanced 10: Rotate a linked list to the right by K positions.
 * 1->2->3->4->5 rotated by 2 gives 4->5->1->2->3.
 */
public class Q10_RotateByK {
    static Node rotate(Node head, int k) {
        if (head == null || head.next == null || k < 0) {
            return head;
        }
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        tail.next = head; // close into a ring
        Node newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] ks = {2, 5, 7, 0};
        for (int k : ks) {
            Node head = ListUtil.fromArray(1, 2, 3, 4, 5);
            System.out.println("Rotate 1..5 by " + k + ": " + ListUtil.toString(rotate(head, k)));
        }
    }
}
