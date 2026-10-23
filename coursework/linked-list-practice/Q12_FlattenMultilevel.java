/*
 * Advanced 12: Flatten a multilevel linked list.
 * Each node has a next pointer and an optional child pointer to another list.
 * The flattened list visits a node, then its whole child list, then continues
 * with next (depth-first), and has no child pointers left.
 */
public class Q12_FlattenMultilevel {
    static class MNode {
        int data;
        MNode next, child;

        MNode(int data) {
            this.data = data;
        }
    }

    static MNode flatten(MNode head) {
        for (MNode cur = head; cur != null; cur = cur.next) {
            if (cur.child == null) {
                continue;
            }
            MNode childHead = flatten(cur.child);
            MNode childTail = childHead;
            while (childTail.next != null) {
                childTail = childTail.next;
            }
            childTail.next = cur.next;
            cur.next = childHead;
            cur.child = null;
        }
        return head;
    }

    static MNode build(int... values) {
        MNode head = null, tail = null;
        for (int v : values) {
            MNode n = new MNode(v);
            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }
        return head;
    }

    static MNode nth(MNode head, int n) {
        for (int i = 1; i < n; i++) {
            head = head.next;
        }
        return head;
    }

    static String show(MNode head) {
        StringBuilder sb = new StringBuilder();
        for (MNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        return sb.append("null").toString();
    }

    public static void main(String[] args) {
        // Level 0: 1 -> 2 -> 3 -> 4
        // 2 has child 7 -> 8 -> 9, where 8 has child 11 -> 12
        // 3 has child 5 -> 6
        MNode head = build(1, 2, 3, 4);
        MNode childOf2 = build(7, 8, 9);
        childOf2.next.child = build(11, 12);
        nth(head, 2).child = childOf2;
        nth(head, 3).child = build(5, 6);

        System.out.println("Flattened: " + show(flatten(head)));
        // Expected: 1 -> 2 -> 7 -> 8 -> 11 -> 12 -> 9 -> 3 -> 5 -> 6 -> 4 -> null
    }
}
