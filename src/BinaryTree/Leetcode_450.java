package BinaryTree;

public class Leetcode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if (root.val==key){
            if (root.left==null&&root.right==null){
                return null;
            }
            if (root.left==null){
                return root.right;
            }
            if (root.right==null){
                return root.left;
            }
            TreeNode min = getMin(root.right);
            root.val=min.val;
            root.right=deleteNode(root.right,min.val);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else if (root.val>key){
            root.left=deleteNode(root.left,key);
        }
        return root;
    }
    public TreeNode getMin(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
