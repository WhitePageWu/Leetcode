package LinkList;

/**
 * @className: Leetcode_92
 * @description: TODO 反转链表2
 * @author: wuyurong
 * @date: 2021/6/14
 **/
public class Leetcode_92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null,next = null,newHead = null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int i = 0;
        ListNode cur = dummyHead;
        while (cur!=null){
            if (i == left - 1){
                pre = cur;
            }
            if (i == left){
                newHead = cur;
            }
            if (i == right){
                next = cur.next;
                cur.next=null;
            }
            cur = cur.next;
            i++;
        }
        pre.next = reverse(newHead);
        newHead.next = next;
        return head;
    }
    public static ListNode reverse(ListNode head){
        ListNode pre = null,cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        node5.next=node6;
        reverseBetween(node1,1,2);
    }
}
