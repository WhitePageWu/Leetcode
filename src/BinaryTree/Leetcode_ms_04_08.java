package BinaryTree;

public class Leetcode_ms_04_08 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        if (left!=null&&right!=null){
            return root;
        }
        if (left!=null||right!=null){
            return left==null?right:left;
        }
        return null;
    }
}
