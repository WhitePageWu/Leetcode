package LinkList;

/**
 * @className: Leetcode_203
 * @description: TODO 类描述
 * @author: wuyurong
 * @date: 2021/7/18
 **/
public class Leetcode_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode cur = newhead;
        while (cur!=null && cur.next!=null){
            while (cur.next!=null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return newhead.next;
    }
}
