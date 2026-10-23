/*
 * Intermediate 8: Merge two sorted linked lists into one sorted list
 * by relinking the existing nodes (no new data nodes allocated).
 */
public class Q8_MergeSortedLists {
    static Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node a = ListUtil.fromArray(1, 3, 5, 7);
        Node b = ListUtil.fromArray(2, 4, 6, 8, 10);
        System.out.println("A: " + ListUtil.toString(a));
        System.out.println("B: " + ListUtil.toString(b));
        System.out.println("Merged: " + ListUtil.toString(merge(a, b)));

        System.out.println("Merge with empty: "
                + ListUtil.toString(merge(null, ListUtil.fromArray(1, 2))));
    }
}
