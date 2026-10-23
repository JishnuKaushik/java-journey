/*
 * Intermediate 7: Detect a cycle using Floyd's tortoise and hare.
 */
public class Q7_DetectCycle {
    static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node acyclic = ListUtil.fromArray(1, 2, 3, 4);
        System.out.println("1->2->3->4->null has cycle: " + hasCycle(acyclic));

        Node cyclic = ListUtil.fromArray(1, 2, 3, 4, 5);
        Node tail = cyclic;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = cyclic.next.next; // 5 points back to 3
        System.out.println("1->2->3->4->5->(back to 3) has cycle: " + hasCycle(cyclic));

        System.out.println("Empty list has cycle: " + hasCycle(null));
    }
}
