package BinaryTree;



import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_ms_04_03 {
    List<ListNode> list;
    Queue<TreeNode> queue;
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree==null){
            ListNode[] arr = new ListNode[1];
            return arr;
        }
        list=new LinkedList<>();
        list.add(new ListNode(tree.val));
        queue=new LinkedList<>();
        queue.offer(tree);
        levelOrder(tree);
        ListNode[] arr = new ListNode[list.size()];
        for (int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
    public void levelOrder(TreeNode root){
        while (!queue.isEmpty()){
            int size = queue.size();
            ListNode head = new ListNode(-1);
            ListNode pre = head;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                    pre.next=new ListNode(node.left.val);
                    pre=pre.next;
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    pre.next=new ListNode(node.right.val);
                    pre=pre.next;
                }
            }
            if (head.next!=null){
                list.add(head.next);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node6.left=node9;
        node6.right=node10;
        new Leetcode_ms_04_03().listOfDepth(node1);
    }
}
