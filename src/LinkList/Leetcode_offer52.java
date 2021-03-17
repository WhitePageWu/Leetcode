package LinkList;

import BinaryTree.TreeNode;

public class Leetcode_offer52 {
    public static void main(String[] args) {
        ListNode node1= new ListNode(4);
        ListNode node2= new ListNode(1);
        ListNode node3= new ListNode(8);
        ListNode node4= new ListNode(4);
        ListNode node5= new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode temp1= new ListNode(5);
        ListNode temp2= new ListNode(0);
        ListNode temp3= new ListNode(1);
        ListNode temp4= new ListNode(8);
        ListNode temp5= new ListNode(4);
        ListNode temp6= new ListNode(5);
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        temp4.next=temp5;
        temp5.next=temp6;
        getIntersectionNode(node1,temp1);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 =headB;
        while (node1!=node2){
            node1=node1!=null?node1.next:headB;
            node2=node2!=null?node2.next:headA;
        }
        return node1;
    }
}
