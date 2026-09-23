class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while(cur!=null){
            ListNode nxt = cur.next;
            ListNode p = dummy;
            while(p.next!=null && p.next.val <= cur.val){
                p = p.next;
            }
            cur.next = p.next;
            p.next = cur;
            cur = nxt;
        }
        return dummy.next;
    }
}
