package LinkList;

//分隔链表
public class Leetcode_86 {
    public static ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        ListNode pre,cur;
        ListNode heads = new ListNode(-1);
        heads.next=head;
        pre=heads;
        cur=heads.next;
        while (cur!=null){
            if (cur.val<x){
                pre.next=cur.next;
                cur.next=null;
                tail.next=cur;
                cur=pre.next;
                tail=tail.next;
            }else{
                pre=pre.next;
                cur=cur.next;
            }
        }
        tail.next=heads.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        partition(node1,3);
    }
}
