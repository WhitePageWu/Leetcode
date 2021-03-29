package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_111 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
//        node2.left=node4;
//        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        System.out.println(minDepth(node1));
    }
    public static int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left!=null&&root.right!=null){
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }else if (root.left!=null){
            return minDepth(root.left)+1;
        }else {
            return minDepth(root.right)+1;
        }
    }
    //BFS
    public static int minDepth1(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left==null&&node.right==null){
                    return depth;
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                depth++;
            }
        }
        return depth;
    }
}
