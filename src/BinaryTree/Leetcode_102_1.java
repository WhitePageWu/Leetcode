package BinaryTree;

import java.util.*;

/**
 * @className: Leetcode_102_1
 * @description: TODO 二叉树的层序遍历二刷
 * @author: wuyurong
 * @date: 2021/5/27
 **/
public class Leetcode_102_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(root.val);
        list.add(list1);
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    subList.add(node.left.val);
                    queue.add(node.left);
                }
                if (node.right!=null){
                    subList.add(node.right.val);
                    queue.add(node.right);
                }
            }
            list.add(subList);
        }
        return list;
    }
}
