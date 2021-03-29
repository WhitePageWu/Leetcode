package LinkList;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_109 {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head==null){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        while (head!=null){
            TreeNode node = new TreeNode(head.val);
            list.add(node);
            head=head.next;
        }
        int size =  list.size();
        return create(list,0,size-1);
    }
    public static TreeNode create(List list,int l ,int r){
        if (l>r){
            return null;
        }
        if (l==r){
            return (TreeNode) list.get(l);
        }
        int mid = l +((r-l)>>1);
        TreeNode root = (TreeNode) list.get(mid);
        root.left = create(list,l,mid-1);
        root.right=create(list,mid+1,r);
        return root;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        sortedListToBST(node1);
    }
}
