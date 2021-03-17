package BinaryTree;

public class Leetcode_ms1712 {

    TreeNode head = new TreeNode(-1);   // 为了返回单向链表的头节点而多设的一个节点
    TreeNode perv = null;               // 指向当前节点的前一个节点
    public  TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    public void helper(TreeNode root) {
        if (root == null) { return;}
        helper(root.left);
        if (perv == null) {     // 第一个节点
            perv = root;        // 记录第一个节点
            head.right = root;  // 记录它，它将作为单链表的表头
        } else {                // 第一个节点之后的节点
            perv.right = root;  // 前一个节点的右指针指向当前节点
            perv = root;        // 更新perv指向
        }
        root.left = null;       // 当前节点的左指针设为null
        helper(root.right);
    }
    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(1);
//        TreeNode node5 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(0);
//        node1.left=node2;
//        node1.right=node3;
//        node2.left=node4;
//        node2.right=node5;
//        node3.left=null;
//        node3.right=node6;
//        node4.left=node7;
//        node4.right=null;
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.right=node2;
        node2.right=node3;
        node3.right=node4;
        node4.right=node5;
        node5.right=node6;
        new Leetcode_ms1712().convertBiNode(node1);
    }
}
