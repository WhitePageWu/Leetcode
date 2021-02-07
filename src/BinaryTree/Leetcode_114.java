package BinaryTree;
//拉伸二叉树为链表
public class Leetcode_114 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        flatten(node1);
    }
    public static void flatten(TreeNode root) {
        if (root==null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode lnode = root.left;
        TreeNode rnode = root.right;
        root.left=null;
        root.right=lnode;
        TreeNode p = root;
        while (p.right!=null){
            p=p.right;
        }
        p.right=rnode;
    }
}
