package BinaryTree;

public class Leetcode_404 {
    static int sum=0;
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left!=null&&(root.left.left==null&&root.left.right==null)){
            sum+=root.left.val;
        }else if(root.left!=null){
            sumOfLeftLeaves(root.left);
        }
        if (root.right!=null&&(root.right.left!=null||root.right.right!=null)){
            sumOfLeftLeaves(root.right);
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        System.out.println(sumOfLeftLeaves(node1));
    }
}
