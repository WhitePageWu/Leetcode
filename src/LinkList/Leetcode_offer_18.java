package LinkList;

public class Leetcode_offer_18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode heads= new ListNode(-1);
        heads.next=head;
        ListNode pre = heads;
        ListNode cur = head;
        while ((cur!=null)){
            if (cur.val==val){
                pre.next=cur.next;
                return heads.next;
            }else {
                pre=pre.next;
                cur=cur.next;
            }
        }
        return head;
    }
}
