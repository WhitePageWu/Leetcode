package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_offer_37 {
    public static String serialize(TreeNode root) {
        if (root==null){
            return "#!";
        }
        String res = root.val+"!";
        res+=serialize(root.left);
        res+=serialize(root.right);
        return res;
    }

    public static TreeNode deserialize(String data) {
        String[] str = data.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i=0;i<str.length;i++){
            queue.offer(str[i]);
        }
        return build(queue);
    }
    public static TreeNode build(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left=build(queue);
        head.right=build(queue);
        return head;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=node6;
        System.out.println(serialize(node1));
    }
}
