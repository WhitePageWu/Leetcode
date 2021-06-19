package BInarySearch;

/**
 * @className: Leetcode_31
 * @description: TODO 搜索旋转排序数组
 * @author: wuyurong
 * @date: 2021/6/8
 **/
public class Leetcode_33_1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target?0:-1;
        }
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[left] <= nums[mid]){
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
