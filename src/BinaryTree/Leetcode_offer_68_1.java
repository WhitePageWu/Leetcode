package BinaryTree;

public class Leetcode_offer_68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        if (p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if (q.val>root.val&&p.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
