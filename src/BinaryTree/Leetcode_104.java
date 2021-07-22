package BinaryTree;

/**
 * @className: Leetcode_104
 * @description: TODO 二叉树的最大深度
 * @author: wuyurong
 * @date: 2021/7/22
 **/
public class Leetcode_104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
