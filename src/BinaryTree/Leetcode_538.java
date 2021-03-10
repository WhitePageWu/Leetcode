package BinaryTree;

import java.util.Stack;

public class Leetcode_538 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2= new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=node6;
        convertBST(node1);
    }
    public static TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode res = root;
        int sum=0;
        while (root!=null||(!stack.isEmpty())){
            if (root!=null){
                stack.push(root);
                root=root.right;
            }else {
                TreeNode node = stack.pop();
                node.val+=sum;
                sum=node.val;
                root=node.left;
            }
        }
        return res;
    }
}
