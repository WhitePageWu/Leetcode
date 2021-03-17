package LinkList;

public class Leetcode_23 {
    //顺序合并
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i=0;i<lists.length;i++){
            ans = mergeTwoList(ans,lists[i]);
        }
        return ans;
    }
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        if (l1==null||l2==null){
            return l1==null?l2:l1;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode aptr = l1,bptr=l2;
        while (aptr!=null&&bptr!=null){
            if (aptr.val<bptr.val){
                tail.next=aptr;
                aptr=aptr.next;
            }else{
                tail.next=bptr;
                bptr=bptr.next;
            }
            tail=tail.next;
        }
        tail.next=(aptr==null?bptr:aptr);
        return head.next;
    }
    //分治
    public static ListNode mergeKLists1(ListNode[] lists) {
        return merger(lists,0,lists.length-1);
    }
    public static ListNode merger(ListNode[] lists,int l,int r){
        if (l==r){
            return lists[l];
        }
        if (l>r){
            return null;
        }
        int mid = l+((r-l)>>1);
        return mergeTwoList(merger(lists,l,mid),merger(lists,mid+1,r));
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node4.next=node5;
        node5.next=node6;
        node7.next=node8;
        ListNode[] lists = {node1,node4,node7};
        mergeKLists(lists);
    }
}
