package Array;

public class Leetcode_35 {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0,right = len;
        while (left<right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,1));;
    }
}
