package BinaryTree;

//二叉树的锯齿形遍历

import java.util.*;

public class Leetcode_103 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        zigzagLevelOrder(node1);
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return list;
        }
        queue.add(root);
        sublist.add(root.val);
        list.add(sublist);
        levelOrder(list,queue,1);
        return list;
    }
    public static void levelOrder(List list,Queue queue,int deepth){
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> sublist = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            TreeNode node = (TreeNode)queue.remove();
            if (node.left!=null){
                qu.add(node.left);
                sublist.add(node.left.val);
            }
            if (node.right!=null){
                qu.add(node.right);
                sublist.add(node.right.val);
            }
        }
        if (sublist.size()!=0){
            if (deepth%2!=0){
                while (!sublist.isEmpty()){
                    stack.push(sublist.get(0));
                    sublist.remove(0);
                }
                while (!stack.isEmpty()){
                    sublist.add(stack.pop());
                }
            }
            list.add(sublist);
            levelOrder(list,qu,++deepth);
        }
    }
}
