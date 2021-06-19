package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: Leetcode_199_1
 * @description: TODO 二叉树的右视图二刷
 * @author: wuyurong
 * @date: 2021/6/17
 **/
public class Leetcode_199_1 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                if (i == 0){
                    list.add(node.val);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
            }
        }
        return list;
    }
}
