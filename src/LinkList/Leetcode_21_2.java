package LinkList;

/**
 * @className: Leetcode_21_2
 * @description: TODO 类描述
 * @author: wuyurong
 * @date: 2021/7/18
 **/
public class Leetcode_21_2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if (l1 != null){
            cur.next = l1;
        }else {
            cur.next = l2;
        }
        return head.next;
    }
}
