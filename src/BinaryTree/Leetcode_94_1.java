package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @className: Leetcode_94_1
 * @description: TODO 二叉树的中序遍历二刷
 * @author: wuyurong
 * @date: 2021/5/29
 **/
public class Leetcode_94_1 {
    List<Integer> list = new ArrayList<>();
    /**
     *@描述 递归遍历
     *@参数 [BinaryTree.TreeNode]
     *@返回值 java.util.List<java.lang.Integer>
     *@创建人 wuyurong
     *@创建时间 2021/5/29
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    /**
     *@描述 迭代遍历
     *@参数 [BinaryTree.TreeNode]
     *@返回值 java.util.List<java.lang.Integer>
     *@创建人 wuyurong
     *@创建时间 2021/5/29
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }
}
