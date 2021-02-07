package BinaryTree;

public class Leetcode_116 {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        if (root==null)
            return null;
        connectTwoNode(root.left,root.right);
        return root;
    }
    public static void connectTwoNode(Node left,Node right){
        if (left==null||right==null){
            return;
        }
        left.next=right;
        connectTwoNode(left.left,left.right);
        connectTwoNode(right.left,right.right);
        connectTwoNode(left.right,right.left);
    }
}
