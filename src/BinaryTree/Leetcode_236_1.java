package BinaryTree;

/**
 * @className: Leetcode_236_1
 * @description: TODO 二叉树的最近公共祖先二刷
 * @author: wuyurong
 * @date: 2021/5/29
 **/
public class Leetcode_236_1 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        //若p,q有一个是根节点，则返回根节点
        if (root == p || root == q){
            return root;
        }
        TreeNode t1 = lowestCommonAncestor(root.left,p,q);
        TreeNode t2 = lowestCommonAncestor(root.right,p,q);
        if (t1 != null && t2 != null){
            return root;
        }
        if (t1!=null){
            return t1;
        }
        if (t2 != null){
            return t2;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        System.out.println(lowestCommonAncestor(node1,node4,node6).val);
    }
}
