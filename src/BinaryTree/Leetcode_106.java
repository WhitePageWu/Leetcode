package BinaryTree;

public class Leetcode_106 {
    public static void main(String[] args) {
        int[] postorder={9,15,7,20,3};
        int[] inorder={9,3,15,20,7};
        buildTree(inorder,postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public static TreeNode build(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        if (postStart>postEnd){
            return null;
        }
        int rootVal = postorder[postEnd];//后序遍历最后一个元素为根节点
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        int leftSize = index-inStart;
        root.left=build(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        root.right=build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }
}
