package BinaryTree;

public class Leetcode_98 {
    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
////        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        node5.left=node1;
//        node5.right=node4;
//        node4.left=node3;
//        node4.right=node6;
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        node.right=node1;
        System.out.println(isValidBST(node));
    }
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

}
