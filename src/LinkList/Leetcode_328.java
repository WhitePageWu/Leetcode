package LinkList;

public class Leetcode_328 {
    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode hodd = odd,heven =even;
        int i=1;
        while(head!=null){
            ListNode pre = head;
            head=head.next;
            pre.next=null;
            if (i%2!=0){
                hodd.next=pre;
                hodd=hodd.next;
            }else {
                heven.next=pre;
                heven=heven.next;
            }
            i++;
        }
        hodd.next=even.next;
        return odd.next;
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
        oddEvenList(null);
    }
}
