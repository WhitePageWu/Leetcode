package BinaryTree;

import java.util.*;

public class Leetcode_113 {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();
    Map<TreeNode,TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return ret;
    }
    public void dfs(TreeNode root,int targetSum){
        if (root==null){
            return;
        }
        path.offerLast(root.val);
        targetSum-=root.val;
        if (root.left==null&&root.right==null&&targetSum==0){
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.pollLast();
    }

    public static void main(String[] args) {

    }
    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        if (root==null){
            return ret;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.add(root);
        queueSum.add(0);
        while (!queueNode.isEmpty()){
            TreeNode node = queueNode.peek();
            int rec = queueSum.peek()+node.val;
            if (node.left==null&&node.right==null){
                if (rec==targetSum){
                    getPath(node);
                }
            }else {
                if (node.left!=null){
                    queueNode.add(root.left);
                    queueSum.add(rec);
                    map.put(node.left,node);
                }
                if (node.right!=null){
                    queueNode.add(root.right);
                    queueSum.add(rec);
                    map.put(node.right,node);
                }
            }
        }
        return ret;
    }
    public void getPath(TreeNode node){
        List<Integer> temp = new ArrayList<>();
        while (node!=null){
            temp.add(0,node.val);
            node = map.get(node);
        }
        ret.add(new LinkedList<>(temp));
    }
}
