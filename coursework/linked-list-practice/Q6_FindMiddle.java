/*
 * Intermediate 6: Find the middle element using slow/fast pointers.
 * For an even-length list this returns the second of the two middle nodes.
 */
public class Q6_FindMiddle {
    static Node middle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node odd = ListUtil.fromArray(1, 2, 3, 4, 5);
        Node even = ListUtil.fromArray(1, 2, 3, 4, 5, 6);
        System.out.println(ListUtil.toString(odd) + " -> middle " + middle(odd).data);
        System.out.println(ListUtil.toString(even) + " -> middle " + middle(even).data);
        System.out.println("Single node -> middle " + middle(ListUtil.fromArray(42)).data);
    }
}
