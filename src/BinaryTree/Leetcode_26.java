package BinaryTree;

public class Leetcode_26 {
    boolean flag = false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null&&B==null){
            return true;
        }
        if (A==null||B==null){
            return false;
        }
        if (A.val==B.val){
            boolean res = isSubTree(A,B);
            if (res==true){
                flag=true;
                return flag;
            }
        }
        return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    public boolean isSubTree(TreeNode A,TreeNode B){
        if (A==null&&B==null){
            return true;
        }
        if (A==null&&B!=null){
            return false;
        }
        if (A!=null&&B==null){
            return true;
        }
        if (A.val!=B.val){
            return false;
        }
        return isSubTree(A.left,B.left)&&isSubTree(A.right,B.right);
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
        TreeNode a =new TreeNode(11);
        TreeNode b = new TreeNode(2);
        a.right=b;
        System.out.println(new Leetcode_26().isSubStructure(node1,a));;
    }
}
