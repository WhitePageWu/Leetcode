package BInarySearch;

public class Leetcode_33 {
    public static void main(String[] args) {
        int[] nums = {4,1};
        int target = 1;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n==0){
            return -1;
        }
        if (n==1){
            return nums[0]==target?0:-1;
        }
        int left = 0,right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[left]<=nums[mid]){
                if (nums[left]<=target&&target<nums[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }else {
                if (nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
