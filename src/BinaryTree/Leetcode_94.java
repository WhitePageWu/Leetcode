package BinaryTree;

//二叉树的中序遍历

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_94 {

    //递归遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        inorder(root,list);
        return list;
    }
    public static void inorder(TreeNode root ,List list){
        if (root.left!=null){
            inorder(root.left,list);
        }
        list.add(root.val);
        if (root.right!=null){
            inorder(root.right,list);
        }
    }
    //迭代遍历，利用栈存储节点
    public List<Integer> inorderTraversal2(TreeNode root) {
        List list = new ArrayList();
        if (root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){//一直将左子树压栈
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=stack.pop();
            list.add(node.val);
            if (node.right!=null) {
                cur = node.right;
            }
        }
        return list;
    }
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||(!stack.empty())){
            if(root!=null){
                stack.push(root);//把根节点放入栈中
                root=root.left;//步骤一，遍历左子树
            }
            else{
                TreeNode tem=stack.pop();
                list.add(tem.val);//步骤二，取根结点的值
                root=tem.right;//步骤三，遍历右子树
            }
        }
        return list;
    }
}
