/*
 * Basic 4: Count the nodes in a list.
 */
public class Q4_CountNodes {
    static int count(Node head) {
        int n = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println("Empty list: " + count(null));
        System.out.println("Single node: " + count(ListUtil.fromArray(1)));
        Node head = ListUtil.fromArray(5, 10, 15, 20, 25);
        System.out.println(ListUtil.toString(head) + " has " + count(head) + " nodes");
    }
}
