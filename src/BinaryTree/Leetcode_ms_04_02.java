package BinaryTree;

public class Leetcode_ms_04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0){
            return null;
        }
        return build(nums,0,nums.length-1);
    }
    public TreeNode build(int[] nums,int left,int right){
        if (left==right){
            return new TreeNode(nums[left]);
        }
        if (left>right){
            return null;
        }
        int mid = left+((right-left)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left=build(nums,left,mid-1);
        root.right=build(nums,mid+1,right);
        return root;
    }
}
