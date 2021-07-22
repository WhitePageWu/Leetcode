package BinaryTree;

import java.util.*;

/**
 * @className: Traverse
 * @description: TODO 二叉树前中后序遍历
 * @author: wuyurong
 * @date: 2021/7/21
 **/
public class Traverse {
    /**
     * 前序遍历
     * */

    //前序递归遍历
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        list.add(root.val);
        if (root.left != null){
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return list;
    }
    //前序迭代遍历
    public List<Integer> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            if (root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }else {
                TreeNode cur = stack.pop();
                if (cur.right != null){
                    root = cur.right;
                }
            }
        }
        return list;
    }

    /**
     * 中序遍历
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        if (root.left != null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null){
            inorderTraversal(root.right);
        }
        return list;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.add(root);
                root = root.left;
            }else {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                root = cur.right;
            }
        }
        return list;
    }

    /**
     *后序遍历
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        if (root.left != null){
            postorderTraversal(root.left);
        }
        if (root.right != null){
            postorderTraversal(root.right);
        }
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                list.add(0,root.val);
                root = root.right;
            }else {
                TreeNode cur = stack.pop();
                root = cur.left;
            }
        }
        return list;
    }
    /**
     * 二叉树的层序遍历
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res  = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                sublist.add(node.val);
                if (node.left != null){
                    queue.addLast(node.left);
                }
                if (node.right != null){
                    queue.addLast(node.right);
                }
            }
            res.add(sublist);
        }
        return res;
    }
}
