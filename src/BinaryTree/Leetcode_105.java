package BinaryTree;

//从前序和中序遍历序列构造二叉树
public class Leetcode_105 {
    public static void main(String[] args) {
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        buildTree(preorder,inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public static TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if (preStart>preEnd||preStart==preorder.length)
            return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //查找root在中序遍历中的索引
        int index = -1;
        for (int i=inStart;i<inEnd;i++){
            if (inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        int leftSize = index-inStart;
        root.left=build(preorder,preStart+1,preStart+leftSize,inorder,inStart,index);
        root.right=build(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return root;
    }
}
