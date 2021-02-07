package BinaryTree;
//翻转二叉树
public class Leetcode_226 {
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
        invertTree(node1);
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root==null)
            return null;
        TreeNode temp = root.left;
        TreeNode rchild = root.right;
        root.left=rchild;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
