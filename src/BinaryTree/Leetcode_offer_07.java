package BinaryTree;

public class Leetcode_offer_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0){
            return null;
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int prestart,int pretail,int[] inorder,int instart,int intail){
        if (prestart>pretail){
            return null;
        }
        int val = preorder[prestart];
        int index = getInOrderIndex(inorder,instart,intail,val);
        TreeNode root = new TreeNode(val);
        if (index==-1){
            return null;
        }
        root.left=build(preorder,prestart+1,index,inorder,0,index-1);
        root.right=build(preorder,index+1,pretail,inorder,index+1,intail);
        return root;
    }
    public int getInOrderIndex(int[] inorder,int start ,int tail ,int target){
        for(int i=start;i<=tail;i++){
            if (inorder[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre={3,9,20,15,7};
        int[] in={9,3,15,20,7};
        new Leetcode_offer_07().buildTree(pre,in);
    }
}
