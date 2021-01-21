package BInarySearch;

public class Leetcode_162 {
    public static void main(String[] args) {
        int[] nums={1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));;
    }
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int left =0,right=n-1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (mid==n-1){
                return n-1;
            }
            if (nums[mid]<nums[mid+1]){
                left=mid+1;
            }else if (nums[mid]>nums[mid+1]){
                right = mid-1;
            }
        }
        return left;
    }
}
