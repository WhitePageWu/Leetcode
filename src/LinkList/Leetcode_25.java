package LinkList;

/**
 * @className: Leetcode_25
 * @description: TODO k个1组反转链表
 * @author: wuyurong
 * @date: 2021/5/26
 **/
public class Leetcode_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k==1){
            return head;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head!=null){
            ListNode tail = pre;
            //判断k是否大于链表长度
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverseMtoN(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }
    public static ListNode[] reverseMtoN(ListNode head,ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
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
        reverseKGroup(node1,2);
    }
}
