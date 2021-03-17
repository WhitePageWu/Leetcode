package BinaryTree;

public class Leetcode_108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0){
            return null;
        }
        return create(nums,0,nums.length-1);
    }
    public static TreeNode create(int[] nums,int start,int end){
        if (start>end){
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = start+((end-start)>>1);
        int root_val = nums[mid];
        TreeNode root = new TreeNode(root_val);
        TreeNode left = create(nums,start,mid-1);
        TreeNode right = create(nums,mid+1,end);
        root.left=left;
        root.right=right;
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }
}
