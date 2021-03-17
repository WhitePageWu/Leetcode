package LinkList;

public class Leetcode_ms0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow = head;
        while (k-->0){
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow.val;
    }
}
