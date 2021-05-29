package BinaryTree;

import java.util.*;

/**
 * @className: Leetcode_103_1
 * @description: TODO 二叉树的锯齿形遍历
 * @author: wuyurong
 * @date: 2021/5/28
 **/
public class Leetcode_103_1 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return list;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i<size;i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            if (depth%2!=0){
                Stack<Integer> stack = new Stack<>();
                while (subList.size()!=0){
                    stack.add(subList.get(0));
                    subList.remove(0);
                }
                while (!stack.isEmpty()){
                    subList.add(stack.pop());
                }
            }
            depth++;
            if (subList.size()!=0){
                list.add(subList);
            }
        }
        return list;
    }

}
