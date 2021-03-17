package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_129 {
    List<Integer> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root,"");
        int sum = 0;
        int i =0;
        while (i<list.size()){
            sum+=list.get(i);
            i++;
        }
        return sum;
    }
    public void dfs(TreeNode root,String str){
        if (root==null){
            return;
        }
        str = str+root.val;
        if (root.left==null&&root.right==null){
            list.add(Integer.valueOf(str));
        }
        dfs(root.left,str);
        dfs(root.right,str);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        new Leetcode_129().sumNumbers(node1);
    }
}
