package DynamicProgramming;

import java.util.Arrays;

/**
 * @className: Leetcode_213_1
 * @description: TODO 打家劫舍2 二刷
 * @author: wuyurong
 * @date: 2021/7/12
 **/
public class Leetcode_213_1 {
    public static int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length-1];
        //先不考虑最后一个元素
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int max1 = dp[dp.length-1];
        Arrays.fill(dp,0);
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i+1]);
        }
        int max2 = dp[dp.length-1];
        return Math.max(max1,max2);
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,2,1};
        System.out.println(rob(nums));
    }
}
