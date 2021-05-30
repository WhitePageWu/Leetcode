package LinkList;

/**
 * @className: Leetcode_142_1
 * @description: TODO 找出环形链表的入环位置
 * @author: wuyurong
 * @date: 2021/5/29
 **/
public class Leetcode_142_1 {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                fast = head;
                while (slow!=null){
                    if (fast == slow){
                        return slow;
                    }
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        //没有环
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next = node3;
        detectCycle(node1);
    }
}
