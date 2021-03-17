package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_95 {
    public static void main(String[] args) {
        generateTrees(5);
    }
    public static List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);
    }
    public static List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allList = new LinkedList<>();
        if (start>end){
            allList.add(null);
            return allList;
        }
        for (int i=start;i<=end;i++){
            List<TreeNode> leftTree = generateTrees(start,i-1);
            List<TreeNode> rightTree = generateTrees(i+1,end);
            for (TreeNode left:leftTree){
                for (TreeNode right:rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    allList.add(root);
                }
            }
        }
        return allList;
    }
}
