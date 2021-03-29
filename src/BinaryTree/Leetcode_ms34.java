package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_ms34 {
    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> queue = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return ret;
    }
    public void dfs(TreeNode root,int target){
        if (root==null){
            return;
        }
        queue.addLast(root.val);
        target-=root.val;
        if (root.left==null&&root.right==null&&target==0){
            ret.add(new LinkedList<>(queue));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        queue.pollLast();
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
        new Leetcode_ms34().pathSum(node1,22);
    }
}
