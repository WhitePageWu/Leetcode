package BinaryTree;

public class Leetcode_563 {
    static int sum = 0;
    public static int findTilt(TreeNode root) {
        if (root==null ){
            return 0;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        sum+=Math.abs(left-right);
        return left+right+root.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        findTilt(node1);
    }
}
