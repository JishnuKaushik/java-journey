class MyLinkedList {

    class Node {
        int val;
        Node next;
        Node(int val){ this.val = val; }
    }

    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node cur = head;
        for(int i=0;i<index;i++) cur = cur.next;
        return cur.val;
    }

    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        size++;
    }

    public void addAtTail(int val) {
        Node n = new Node(val);
        if(head==null){
            head = n;
            size++;
            return;
        }
        Node cur = head;
        while(cur.next!=null) cur = cur.next;
        cur.next = n;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index <= 0){
            addAtHead(val);
            return;
        }
        Node cur = head;
        for(int i=0;i<index-1;i++){
            cur = cur.next;
        }
        Node n = new Node(val);
        n.next = cur.next;
        cur.next = n;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) return;
        if(index==0){
            head = head.next;
            size--;
            return;
        }
        Node cur = head;
        for(int i=0;i<index-1;i++) cur=cur.next;
        cur.next = cur.next.next;
        size--;
    }
}
