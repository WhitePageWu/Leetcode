package LinkList;

public class Leetcode_725 {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int len =0;
        ListNode cur = root;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        cur=root;
        ListNode[] list = new ListNode[k];
        int i=0;
        if (len<=k){
            while (cur!=null){
                ListNode node = cur;
                cur=cur.next;
                node.next=null;
                list[i]=node;
                i++;
            }
        }else {
            int subLen = len/k;
            int subNum = len%k;
            for (int j=0;j<subNum;j++){
                list[i]=cur;
                int h = 0;
                while (h<subLen&&cur!=null){
                    cur=cur.next;
                    h++;
                }
                ListNode pre = cur;
                cur=cur.next;
                pre.next=null;
            }
            for (int x =i;x<k;x++){
                int l =0;
                list[x]=cur;
                while (l<subLen-1&&cur!=null){
                    cur=cur.next;
                    l++;
                }
                ListNode pre = cur;
                cur=cur.next;
                pre.next=null;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
//        node7.next=node8;
//        node8.next=node9;
//        node9.next=node10;
        splitListToParts(node1,3);
    }
}
