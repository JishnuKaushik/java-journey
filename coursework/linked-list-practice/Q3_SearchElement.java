/*
 * Basic 3: Search for an element. Returns its 1-based position, or -1 if absent.
 */
public class Q3_SearchElement {
    static int search(Node head, int key) {
        int position = 1;
        for (Node cur = head; cur != null; cur = cur.next, position++) {
            if (cur.data == key) {
                return position;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Node head = ListUtil.fromArray(7, 14, 21, 28);
        System.out.println("List: " + ListUtil.toString(head));
        System.out.println("Search 21: position " + search(head, 21));
        System.out.println("Search 7: position " + search(head, 7));
        System.out.println("Search 99: position " + search(head, 99));
        System.out.println("Search in empty list: position " + search(null, 1));
    }
}
