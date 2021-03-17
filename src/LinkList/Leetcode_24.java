package LinkList;

public class Leetcode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode l = head;
        ListNode r = head.next;
        while (l!=null&&r!=null){
            int temp = l.val;
            l.val=r.val;
            r.val=temp;
            l=l.next.next;
            if (l!=null){
                r=l.next;
            }
        }
        return head;
    }
    //递归
    public ListNode swapPairs1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next=swapPairs1(newHead.next);
        newHead.next=head;
        return newHead;
    }
}
