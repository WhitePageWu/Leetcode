package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_102 {
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
        levelOrder(node1);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null) {
            return list;
        }
        queue.add(root);
        List<Integer> sublist = new ArrayList<>();
        sublist.add(root.val);
        list.add(sublist);
        levelorder(list,queue);
        return list;
    }
    public static void levelorder(List<List<Integer>> list, Queue queue){
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> sublist = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = (TreeNode) queue.remove();
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
            list.add(sublist);
            levelorder(list,qu);
        }
    }
}
