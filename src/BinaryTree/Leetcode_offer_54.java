package BinaryTree;

public class Leetcode_offer_54 {
    int n;
    int val;
    public int kthLargest(TreeNode root, int k) {
        n=k;
        traverse(root);
        return val;
    }
    public void traverse(TreeNode root){
        if (root==null ){
            return;
        }
        traverse(root.right);
        n--;
        if (n==0){
            val=root.val;
            return;
        }
        traverse(root.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=node6;
        new Leetcode_offer_54().kthLargest(node1,3);
    }
}
