/*
 * Basic 1: Insert a node at the Nth position (1-based).
 */
public class Q1_InsertAtNthPosition {
    static Node insertAt(Node head, int position, int value) {
        if (position < 1) {
            throw new IllegalArgumentException("Position must be >= 1");
        }
        Node node = new Node(value);
        if (position == 1) {
            node.next = head;
            return node;
        }
        Node prev = head;
        for (int i = 1; i < position - 1 && prev != null; i++) {
            prev = prev.next;
        }
        if (prev == null) {
            throw new IllegalArgumentException("Position out of range");
        }
        node.next = prev.next;
        prev.next = node;
        return head;
    }

    public static void main(String[] args) {
        Node head = ListUtil.fromArray(10, 20, 40, 50);
        System.out.println("Original: " + ListUtil.toString(head));

        head = insertAt(head, 3, 30);
        System.out.println("Insert 30 at 3: " + ListUtil.toString(head));

        head = insertAt(head, 1, 5);
        System.out.println("Insert 5 at 1: " + ListUtil.toString(head));

        head = insertAt(head, 7, 60);
        System.out.println("Insert 60 at 7 (end): " + ListUtil.toString(head));

        try {
            insertAt(head, 20, 99);
        } catch (IllegalArgumentException e) {
            System.out.println("Insert at 20: " + e.getMessage());
        }
    }
}
