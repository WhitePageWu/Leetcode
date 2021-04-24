package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Deque<Integer> path=new LinkedList<>();
        dfs(root,path,targetSum);
        return res;
    }
    public void dfs(TreeNode root,Deque<Integer> path,int targetSum){
        if (root==null){
            return;
        }
        if (root.left==null&&root.right==null&&root.val==targetSum){
            path.addLast(root.val);
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        path.addLast(root.val);
        dfs(root.left,path,targetSum-root.val);
        dfs(root.right,path,targetSum-root.val);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node6.right=node9;
        new Leetcode().pathSum(node1,22);
    }
}
