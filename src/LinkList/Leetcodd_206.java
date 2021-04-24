package LinkList;

import BinaryTree.TreeNode;

import java.util.Stack;

public class Leetcodd_206 {
    //迭代
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    //递归
    public static  ListNode reverseList2(ListNode head) {
        if(head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        reverseList(node1);
    }
}
