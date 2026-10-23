/*
 * Advanced 11: Remove a cycle from a linked list.
 * Floyd's algorithm finds the meeting point; restarting one pointer from head
 * finds the cycle start; stopping on the node before it lets us cut the cycle.
 */
public class Q11_RemoveCycle {
    static void removeCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return; // no cycle
        }

        slow = head;
        if (slow == fast) {
            // cycle starts at head: find the last node of the ring
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null; // fast is now the last node of the cycle
    }

    public static void main(String[] args) {
        Node head = ListUtil.fromArray(1, 2, 3, 4, 5);
        Node tail = head.next.next.next.next;
        tail.next = head.next.next; // 5 -> 3
        System.out.println("Before: cycle = " + Q7_DetectCycle.hasCycle(head));
        removeCycle(head);
        System.out.println("After: cycle = " + Q7_DetectCycle.hasCycle(head));
        System.out.println("List: " + ListUtil.toString(head));

        Node ring = ListUtil.fromArray(1, 2, 3);
        ring.next.next.next = ring; // cycle starts at head
        removeCycle(ring);
        System.out.println("Cycle at head removed: " + ListUtil.toString(ring));

        Node plain = ListUtil.fromArray(1, 2, 3);
        removeCycle(plain);
        System.out.println("No cycle, unchanged: " + ListUtil.toString(plain));
    }
}
