package LinkList;

public class Leetcode_offer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head,slow = head;
        while (--k>0){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
