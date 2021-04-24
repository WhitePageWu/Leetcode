package LinkList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
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
        ListNode nod1=new ListNode(10);
        ListNode nod2 = new ListNode(11);
        nod1.next=nod2;
        nod2.next=node5;
        getIntersectionNode(nod1,node1);
    }
}
