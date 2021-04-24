package LinkList;

public class Leetcode_445 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);
        l1=rl1;
        l2=rl2;
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return reverse(head);
    }
    private static ListNode reverse(ListNode head){
        if (head.next==null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        node5.next=node6;
        node6.next=node7;
        addTwoNumbers(node1,node5);
    }
}
