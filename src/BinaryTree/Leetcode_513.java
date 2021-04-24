package BinaryTree;

public class Leetcode_513 {
    Integer val=null;
    int h;
    public int findBottomLeftValue(TreeNode root) {
        if (root==null){
            return -1;
        }
        h=getHeight(root);
        dfs(root,1);
        return val;
    }
    public void dfs(TreeNode root,int depth){
        if (root==null){
            return;
        }
        if (root!=null&&depth==h){
            val=root.val;
            return;
        }
        if (val==null){
            dfs(root.left,depth+1);
        }
        if (val==null){
            dfs(root.right,depth+1);
        }
    }
    public int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node6.left=node9;
        node6.right=node10;
        new Leetcode_513().findBottomLeftValue(node1);
    }
}
