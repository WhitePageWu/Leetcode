package BinaryTree;

/**
 * @className: Leetcode_101_1
 * @description: TODO 对称二叉树
 * @author: wuyurong
 * @date: 2021/7/22
 **/
public class Leetcode_101_1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return help(root.left, root.right);
    }
    public boolean help(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return help(left.left, right.right) && help(left.right, right.left);
    }
}
