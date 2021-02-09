package BinaryTree;

import LinkList.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_652 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.left=node6;
        node5.left=node7;
        findDuplicateSubtrees(node1);
    }
    static List<TreeNode> list = new ArrayList<>();
    static Map<String,Integer> map = new HashMap<>();
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return list;
    }
    public static String traverse(TreeNode root){
        if (root==null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String temp = left+","+right+","+root.val;
        int freq = map.getOrDefault(temp,0);
        if (freq==1){
            list.add(root);
        }
        map.put(temp,freq+1);
        return temp;
    }
}
