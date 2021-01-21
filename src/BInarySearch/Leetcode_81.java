package BInarySearch;

public class Leetcode_81 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n==0){
            return false;
        }
        if (n==1){
            return nums[0]==target;
        }
        int i =0;
        int left = 0,right = n-1;
        while (left<=right){
            while (left<right&&nums[left]==nums[left+1])
                left++;
            while (left<right&&nums[right]==nums[right-1])
                right--;
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return true;
            }
            if (nums[left]<=nums[mid]){
                if (nums[left]<=target&&target<=nums[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }else {
                if (nums[mid]<=target&&target<=nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }
        return false;
    }
}
