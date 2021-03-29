package BinaryTree;

//二叉树的后续遍历

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left= new TreeNode(4);
        TreeNode right = new TreeNode(5);
        root.right=right;
        right.right=left;
        postorderTraversal(root);
    }
    //迭代法
    public static List<Integer> postorderTraversal(TreeNode root) {
        List list = new ArrayList();
        if (root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty()||cur!=null){
            while (cur.left!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=null;
            if (!stack.isEmpty()){
                node = stack.pop();
                list.add(node.left);
            }
            if (node.right!=null){
                cur=node.right;
            }
        }
        return list;
    }
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||(!stack.empty())){
            if(root!=null){
                stack.push(root);//把根节点放入栈中
                list.add(0,root.val);//步骤一，在index=0处插入根结点的值
                root=root.right;//步骤二，遍历右子树
            }
            else{
                TreeNode tem=stack.pop();
                root=tem.left;//步骤三，遍历左子树
            }
        }
        return list;
    }

}
