package DynamicProgramming;

/**
 * @className: Leetcode_152_1
 * @description: TODO 乘积最大数组
 * @author: wuyurong
 * @date: 2021/7/15
 **/
public class Leetcode_152_1 {
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i <dp.length; i++){
            if (nums[i] >= 0){
                dp[i][0] = Math.min(dp[i-1][0]*nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i-1][1]*nums[i], nums[i]);
            }else {
                dp[i][0] = Math.min(dp[i-1][1]*nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i-1][0]*nums[i], nums[i]);
            }
        }
        int max = dp[0][1];
        for (int i = 1; i < dp.length; i++){
            max = Math.max(max,dp[i][1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
