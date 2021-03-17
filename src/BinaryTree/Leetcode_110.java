package BinaryTree;

public class Leetcode_110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);
        if (Math.abs(lheight-rheight)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
