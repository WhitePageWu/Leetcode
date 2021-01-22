package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left= new TreeNode(4);
        TreeNode right = new TreeNode(5);
        root.right=right;
        right.right=left;
        System.out.println(preorderTraversal1(root));;
    }
    //方法一：递归的方法去遍历
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List list = new ArrayList<Integer>();
        if (root==null)
            return list;
        preOrder(root,list);
        return list;
    }
    public static void preOrder(TreeNode root,List list){
        int val = root.val;
        list.add(val);
        if (root.left!=null){
            preOrder(root.left,list);
        }
        if (root.right!=null){
            preOrder(root.right,list);
        }
    }
    //方法二：迭代的方法遍历
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List list = new ArrayList<Integer>();
        if (root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        list.add(root.val);
        TreeNode node = root;
        while (!stack.isEmpty()||node!=null){
            while (node!=null){
                list.add(node.val);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            node=node.right;
        }
        return list;
    }
    //迭代实现二
    public static void preOrderIteration3(TreeNode root) {
        List list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

}