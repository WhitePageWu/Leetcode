package LinkList;

public class Leetcode_83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while (next!=null){
            while (cur.val==next.val){
                ListNode next_next = next.next;
                cur.next=next_next;
                next=cur.next;
                if (next==null){
                    return head;
                }
            }
            cur=cur.next;
            next=next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        deleteDuplicates(node1);
    }
}
