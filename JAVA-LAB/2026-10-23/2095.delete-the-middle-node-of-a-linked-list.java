class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        // fast starts two ahead so slow stops on the node just before the middle.
        ListNode slow = head, fast = head.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
