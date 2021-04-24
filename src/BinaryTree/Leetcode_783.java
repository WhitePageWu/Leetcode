package BinaryTree;

public class Leetcode_783 {
    int pre;
    int ans;
    public int minDiffInBST(TreeNode root) {
       pre = -1;
       ans=Integer.MAX_VALUE;
       preOrder(root);
       return ans;
    }
    public void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        preOrder(root.left);
        if (pre==-1){
            pre=root.val;
        }else {
            ans=Math.min(ans,root.val-pre);
            pre=root.val;
        }
        preOrder(root.right);
    }
}
