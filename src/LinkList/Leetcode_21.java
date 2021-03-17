package LinkList;

//合并两个升序链表

public class Leetcode_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode head = new ListNode(0);
        ListNode root =head;
        while (head1!=null&&head2!=null){
            if (head1.val<= head2.val){
                head.next=new ListNode(head1.val);
                head1=head1.next;
            }else {
                head.next= new ListNode(head2.val);
                head2=head2.next;
            }
            head=head.next;
        }
        if (head1!=null){
            head.next=head1;
        }
        if (head2!=null){
            head.next=head2;
        }
        return root.next;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        if (l1.val<=l2.val){
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}
