package LinkList;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_142 {
    public static ListNode detectCycle(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next=head;
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur!=null){
            pre.next=null;
            if (hasCircle(cur)){
                pre.next=cur;
                pre=pre.next;
                cur=cur.next;
            }else{
                pre.next=cur;
                newHead=null;
                return cur;
            }
        }
        return null;
    }
    public static boolean hasCircle(ListNode head){
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        detectCycle(node);
    }
}
