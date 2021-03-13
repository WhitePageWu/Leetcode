package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);
    }
    public static List<TreeNode> generateTrees(int start, int end){

    }
}
