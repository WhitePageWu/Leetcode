package BInarySearch;

public class Leetcode_704 {
    public static void main(String[] args) {
        int[] nums={1,2,5,6};
        System.out.println(search2(nums,4));
    }
    //方法一，逐步排除不可能是答案的区间
    public static int search1(int[] nums, int target) {
        int len = nums.length;
        int left = 0,right = len-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if (nums[mid]<target)
                left=mid+1;
            else
                right=mid;
        }
        if (nums[left]==target)
            return left;
        else
            return -1;
    }
    //直接在方法里面找出元素
    public static int search2(int[] nums, int target) {
        int len = nums.length;
        int left = 0,right = len-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target)
                return mid;
            else if (nums[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
            return -1;
    }
}
