package BinaryTree;

public class Leetcode_543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return max;
    }
    public void calculate(TreeNode root){
        if (root==null){
            return;
        }
        int lh = getHeight(root.left);
        int rh=getHeight(root.right);
        if ((lh+rh)>max){
            max=lh+rh;
        }
        calculate(root.left);
        calculate(root.right);
    }
    private int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        new Leetcode_543().diameterOfBinaryTree(node1);
    }
}
