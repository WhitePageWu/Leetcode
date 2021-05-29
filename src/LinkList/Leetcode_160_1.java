package LinkList;

/**
 * @className: Leetcode_160_1
 * @description: TODO 相交链表二刷
 * @author: wuyurong
 * @date: 2021/5/27
 **/
public class Leetcode_160_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA,h2 = headB;
        while (h1!=null||h2!=null){
            if (h1==h2){
                return h1;
            }
            if (h1==null){
                h1 = headB;
                h2 = h2.next;
            }else if (h2 == null){
                h1 = h1.next;
                h2 = headA;
            }else {
                h1=h1.next;
                h2=h2.next;
            }
        }
        return null;
    }
}
