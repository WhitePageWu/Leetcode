package BinaryTree;

public class Leetcode_ms_04_05 {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelp(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean isValidBSTHelp(TreeNode root,int min,int max){
        if (root==null){
            return true;
        }
        if (root.val<=min||root.val>=max){
            return false;
        }
        return isValidBSTHelp(root.left,min,root.val)&&isValidBSTHelp(root.right,root.val,max);
    }
}
