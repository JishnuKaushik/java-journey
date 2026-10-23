/*
 * Basic 2: Delete the node at a given position (1-based).
 */
public class Q2_DeleteAtPosition {
    static Node deleteAt(Node head, int position) {
        if (head == null || position < 1) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 1) {
            return head.next;
        }
        Node prev = head;
        for (int i = 1; i < position - 1 && prev.next != null; i++) {
            prev = prev.next;
        }
        if (prev.next == null) {
            throw new IllegalArgumentException("Position out of range");
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node head = ListUtil.fromArray(1, 2, 3, 4, 5);
        System.out.println("Original: " + ListUtil.toString(head));

        head = deleteAt(head, 3);
        System.out.println("Delete position 3: " + ListUtil.toString(head));

        head = deleteAt(head, 1);
        System.out.println("Delete position 1: " + ListUtil.toString(head));

        head = deleteAt(head, 3);
        System.out.println("Delete position 3 (last): " + ListUtil.toString(head));

        try {
            deleteAt(head, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Delete position 10: " + e.getMessage());
        }
    }
}
