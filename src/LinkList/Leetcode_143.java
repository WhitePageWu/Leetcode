package LinkList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leetcode_143 {
    public static void reorderList(ListNode head) {
        ListNode fast,slow;
        fast=head;
        slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if (fast==slow){
            return;
        }
        ListNode nodes = head;
        while (nodes.next!=slow){
            nodes=nodes.next;
        }
        nodes.next=null;
        Stack<ListNode> stack = new Stack<>();
        while (slow!=null){
            stack.add(slow);
            slow=slow.next;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        int i = 1;
        while (head!=null&&stack.size()!=0){
            if (i%2!=0){
                cur.next = head;
                head=head.next;
                cur=cur.next;
            }else{
                ListNode node = stack.pop();
                cur.next=node;
                cur=cur.next;
            }
            i++;
        }
        cur.next=null;
        while (stack.size()!=0){
            cur.next=stack.pop();
            cur=cur.next;
        }
        cur.next=null;
        head=newHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        reorderList(node1);
    }
}
