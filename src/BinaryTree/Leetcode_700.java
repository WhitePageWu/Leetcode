package BinaryTree;

public class Leetcode_700 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        searchBST(node1,2);
    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        } else if (root.val<val){
           return searchBST(root.right,val);
        }else{
           return searchBST(root.left,val);
        }
    }
}
