package LinkList;

public class Leetcode_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1!=null&&l2!=null){
            int temp = l1.val+l2.val+flag;
            flag = temp/10;
            temp=temp%10;
            ListNode node = new ListNode(temp);
            cur.next=node;
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int temp = l1.val+flag;
            flag = temp/10;
            temp=temp%10;
            ListNode node = new ListNode(temp);
            cur.next=node;
            cur=cur.next;
            l1=l1.next;
        }
        while (l2!=null){
            int temp = l2.val+flag;
            flag = temp/10;
            temp=temp%10;
            ListNode node = new ListNode(temp);
            cur.next=node;
            cur=cur.next;
            l2=l2.next;
        }
        if (flag!=0){
            ListNode node = new ListNode(flag);
            cur.next=node;
        }
        return head.next;
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
//        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        addTwoNumbers(node1,node4);
    }
}
