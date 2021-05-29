package LinkList;

public class Leetcode_24 {
    public static ListNode swapPairs(ListNode head) {
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
    public static ListNode swapPairs1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next=swapPairs1(newHead.next);
        newHead.next=head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        swapPairs(node1);
    }
}
