package Array;

import java.util.Arrays;

/**
 * @className: Leetcode_217
 * @description: TODO 存在重复元素
 * @author: wuyurong
 * @date: 2021/7/14
 **/
public class Leetcode_217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2){
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1^1);
    }
}
