package BinaryTree;

import LinkList.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_257 {
    List<String> list = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null){
            list.add(new String(""));
            return list;
        }
        if (root.left==null&&root.right==null){
            list.add(""+root.val);
        }
        if (root.left!=null){
            dfs(root.left,""+root.val);
        }
        if (root.right!=null){
            dfs(root.right,""+root.val);
        }

        return list;
    }
    public void dfs(TreeNode root,String str){
        if (root!=null){
            str=str+"->"+root.val;
        }
        if (root.left==null&&root.right==null){
            list.add(str.toString());
        }
        if (root.left!=null){
            dfs(root.left,str);
        }
        if (root.right!=null){
            dfs(root.right,str);
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
//        node1.left=node2;
//        node1.right=node3;
//        node2.right=node5;
        new Leetcode_257().binaryTreePaths(node1);
    }
}
