package BinaryTree;

public class Leetcode_ms_04_04 {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int lh = getHeight(root.left);
        int rh=getHeight(root.right);
        if (Math.abs(lh-rh)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public  int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}

