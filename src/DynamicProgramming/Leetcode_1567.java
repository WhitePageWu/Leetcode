package DynamicProgramming;

/**
 * @className: Leetcode_1567
 * @description: TODO 乘积为正数的最长子数组长度
 * @author: wuyurong
 * @date: 2021/7/15
 **/
public class Leetcode_1567 {
    public static int getMaxLen(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        if (nums[0]<0){
            dp[0][0] = 1;
        }else if (nums[0]>0){
            dp[0][1] = 1;
        }
        int max = dp[0][1];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > 0){
                dp[i][0] = dp[i-1][0] > 0? dp[i-1][0] +1: 0;
                dp[i][1] = dp[i-1][1] +1;
            }
            if (nums[i] < 0){
                dp[i][0] = dp[i-1][1] +1;
                dp[i][1] = dp[i-1][0] >0? dp[i-1][0] +1:0;
            }
            if (nums[i] == 0){
                dp[i][0] = 0;
                dp[i][1] = 0;
            }
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2,-3,4};
        System.out.println(getMaxLen(nums));
    }
}
