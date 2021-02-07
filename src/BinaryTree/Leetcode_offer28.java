package BinaryTree;

/**
 * 对称二叉树的判定
 * */
public class Leetcode_offer28 {
    public static boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return recur(root.left,root.right);
    }
    public static boolean recur(TreeNode left,TreeNode right){
        if (left==null&&right==null)
            return true;
        if (left==null||right==null||left.val!=right.val){
            return false;
        }
        return recur(left.left,right.right)&&recur(left.right,right.left);
    }

    public static boolean isSymmetric1(TreeNode root){
        if(root==null){
            return true;
        }
        TreeNode p0 = root;
        TreeNode p = reverse(p0);
        return compare(root,p);
    }
    public static boolean compare(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        else if(root1==null && root2!=null){
            return false;
        }
        else if(root1!=null && root2==null){
            return false;
        }
        else if(root1.val != root2.val){
            return false;
        }
        else return compare(root1.left,root2.left) && compare(root1.right,root2.right);
    }

    public static TreeNode reverse(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;
        reverse(root.left);
        reverse(root.right);
        return root;
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
        System.out.println(isSymmetric1(node1));
    }
}
