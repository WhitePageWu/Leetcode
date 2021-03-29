package BinaryTree;

import java.util.*;

public class Leetcode_offer_32_1 {
    List<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue=new LinkedList<>();
    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        list.add(root.val);
        queue.add(root);
        levelTraverse(root);
        return list.stream().mapToInt(i->i).toArray();
    }
    public void levelTraverse(TreeNode root){
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    list.add(node.left.val);
                    queue.add(node.left);;
                }
                if (node.right!=null){
                    list.add(node.right.val);
                    queue.add(node.right);
                }
            }

        }
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
        new Leetcode_offer_32_1().levelOrder(node1);
    }
}
