package BinaryTree;

public class Leetcode_437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int ret = dfs(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
        return ret;
    }
    public int dfs(TreeNode root,int targetSum){
        if (root==null){
            return 0;
        }
        int ret = 0;
        if (root.val==targetSum){
            ret++;
        }
        ret+=dfs(root.left,targetSum-root.val)+dfs(root.right,targetSum-root.val);
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right=node2;
        node2.right=node3;
        node3.right=node4;
        node4.right=node5;
        new Leetcode_437().pathSum(node1,3);
    }
}
