package LinkList;

/**
 * @className: Leetcode_141_1
 * @description: TODO 环形链表
 * @author: wuyurong
 * @date: 2021/7/18
 **/
public class Leetcode_141_1 {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
