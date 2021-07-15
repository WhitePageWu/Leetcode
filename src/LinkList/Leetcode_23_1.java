package LinkList;

import java.util.List;

/**
 * @className: Leetcode_23_1
 * @description: TODO 合并k个上升链表二刷
 * @author: wuyurong
 * @date: 2021/6/25
 **/
public class Leetcode_23_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l, int r){
        if (l == r){
            return lists[l];
        }
        if (l > r){
            return null;
        }
        int mid = l+((r-l)>>1);
        return mergeTwoLists(merge(lists,l,mid), merge(lists,mid+1,r));
    }
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
