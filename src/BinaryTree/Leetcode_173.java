package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_173 {
    List<TreeNode> list = new LinkedList<>();
    public Leetcode_173(TreeNode root){
        BSTIterator(root);
    }
    public void BSTIterator(TreeNode root) {
        if (root==null){
            return;
        }
        BSTIterator(root.left);
        list.add(root);
        BSTIterator(root.right);
    }
    public int next() {
        if (hasNext()) {
            int re = list.get(0).val;
            list.remove(0);
            return re;
        }else {
            return -1;
        }
    }

    public boolean hasNext() {
        return list.size()==0?false:true;
    }
}
