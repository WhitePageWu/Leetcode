package DynamicProgramming;

/**
 * @className: Leetcode_198
 * @description: TODO 打家劫舍
 * @author: wuyurong
 * @date: 2021/5/27
 **/
public class Leetcode_198 {
    public static int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        System.out.println(rob(nums));
    }
}
