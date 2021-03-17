package LinkList;

public class Leetcode_61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||k==0){
            return head;
        }
        ListNode fast ,slow;
        fast=head;
        slow=head;
        ListNode newHead=null;
        while (k-->0){
            fast=fast.next;
            if (fast==null){
                fast=head;
            }
        }
        if (fast==slow){
            return head;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        newHead = slow.next;
        slow.next=null;
        fast.next=head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        rotateRight(head,1);
    }
}
