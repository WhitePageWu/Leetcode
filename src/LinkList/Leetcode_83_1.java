package LinkList;

/**
 * @className: Leetcode_83_1
 * @description: TODO 删除链表中的重复项
 * @author: wuyurong
 * @date: 2021/7/19
 **/
public class Leetcode_83_1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode l1 = head, l2 = head.next;
        while (l2 != null){
            if (l1.val == l2.val){
                l1.next = l2.next;
                l2 = l1.next;
            }else {
                l1 = l2;
                l2 = l1.next;
            }
        }
        return head;
    }
}
