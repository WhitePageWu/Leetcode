package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_ms_04_06 {
    TreeNode node;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        node= new TreeNode(Integer.MAX_VALUE);
        findGreater(root,p);
        if (node.val==Integer.MAX_VALUE){
            return null;
        }
        return node;
    }
    public void findGreater(TreeNode root,TreeNode p){
        if (root==null){
            return;
        }
        if (root==p||root.val<p.val){
            findGreater(root.right,p);
        }
        if (root.val>p.val){
            if (root.val<node.val){
                node=root;
            }
            findGreater(root.left,p);
        }
    }
}
