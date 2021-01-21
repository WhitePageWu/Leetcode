package BInarySearch;

public class Leetcode_34 {
    public static void main(String[] args) {
        int[] nums={1};
        searchRange2(nums,0);
    }
    //法一
    public static int[] searchRange1(int[] nums, int target) {
        int len = nums.length;
        if (len==0) {
            return new int[]{-1,-1};
        }
        int left = 0,right = len-1;
        int start=-1,end=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid-1;
            } else{
                right= mid-1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            start = -1;
        else
            start=left;
        left=0;
        right=len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid-1;
            } else{
                left=mid+1;
            }
        }
        if (right < 0 || nums[right] != target)
            end= -1;
        else
            end = right;
        if (start<=end) {
            return new int[]{start,end};
        } else {
            return new int[]{-1,-1};
        }
    }

    //法二
    public static int[] searchRange2(int[] nums, int target) {
        int len = nums.length;
        if (len==0) {
            return new int[]{-1,-1};
        }
        int left = 0,right = len;
        int start=-1,end=-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid;
            } else{
                right= mid;
            }
        }
        if (left >= nums.length || nums[left] != target)
            start = -1;
        else
            start=left;
        left=0;
        right=len;
        while(left<right){
            int mid = left+(right-left)/2;
            if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid;
            } else{
                left=mid+1;
            }
        }
        if (right == 0)
            end= -1;
        else
            end = nums[right-1] == target ? (right-1) : -1;
        if (start<=end) {
            return new int[]{start,end};
        } else {
            return new int[]{-1,-1};
        }
    }

    //法三
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len==0) {
            return new int[]{-1,-1};
        }
        int left = 0,right = len-1;
        int start=-1,end=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid-1;
            } else{
                if (mid!=0&&nums[mid-1]==target) {
                    right=mid-1;
                } else{
                    start=mid;
                    break;
                }
            }
        }
        left=0;
        right=len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid-1;
            } else{
                if (mid!=len-1&&nums[mid+1]==target) {
                    left=mid+1;
                } else{
                    end=mid;
                    break;
                }
            }
        }
        if (start<=end) {
            return new int[]{start,end};
        } else {
            return new int[]{-1,-1};
        }
    }
}
