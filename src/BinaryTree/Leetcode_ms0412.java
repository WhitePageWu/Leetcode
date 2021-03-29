package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_ms0412 {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();
    public int pathSum(TreeNode root, int sum) {
        if (root==null){
            return 0;
        }
        dfs(root, sum);
        dfs(root.left,sum);
        dfs(root.right,sum);
        return ret.size();

    }


    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum==root.val){
            List list = new LinkedList<>();
            list.add(root);
            ret.add(list);
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }
}
