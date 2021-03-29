package LinkList;

public class Leetcode_offer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur =head;
        while (k-->0){
            cur=cur.next;
        }
        while (cur!=null){
            pre=pre.next;
            cur=cur.next;
        }
        return pre;
    }
}
