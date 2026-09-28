class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(mid);
        return merge(l,r);
    }

    ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(a!=null && b!=null){
            if(a.val<=b.val){
                cur.next = a;
                a = a.next;
            }else{
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a!=null) ? a : b;
        return dummy.next;
    }
}
