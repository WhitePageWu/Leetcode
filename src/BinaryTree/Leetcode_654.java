package BinaryTree;
//最大二叉树
public class Leetcode_654 {
    public static void main(String[] args) {
        int[] nums ={3};
        constructMaximumBinaryTree(nums);
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums,0,nums.length);
    }
    public static TreeNode constructTree(int[] nums,int l,int r){
        if (l==r){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i=l;i<r;i++){
            if (max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=constructTree(nums,l,index);
        root.right=constructTree(nums,index+1,r);
        return root;
    }
}
