package LinkList;

/**
 * @className: Leetcode_21_1
 * @description: TODO 合并两个有序链表二刷
 * @author: wuyurong
 * @date: 2021/5/27
 **/
public class Leetcode_21_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1!=null&&l2!=null){
            if (l1.val<= l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        cur.next = l1==null?l2:l1;
        return head.next;
    }
}
