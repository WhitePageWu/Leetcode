package BinaryTree;

public class Leetcode_101 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        System.out.println(isSymmetric(node1));
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return look(root.left,root.right);
    }
    public static boolean look(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        return look(left.left,right.right)&&look(left.right,right.left);
    }
}
