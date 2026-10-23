/*
 * Helpers shared by the exercises: build a list from an array and print it.
 */
public class ListUtil {
    static Node fromArray(int... values) {
        Node head = null, tail = null;
        for (int v : values) {
            Node n = new Node(v);
            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }
        return head;
    }

    static String toString(Node head) {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        return sb.append("null").toString();
    }
}
