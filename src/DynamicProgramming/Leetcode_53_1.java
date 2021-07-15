package DynamicProgramming;

/**
 * @className: Leetcode_53_1
 * @description: TODO 最大子序和二刷
 * @author: wuyurong
 * @date: 2021/7/14
 **/
public class Leetcode_53_1 {
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int sum = dp[0];
        for (int i = 1; i < len; i++){
            if (sum > 0){
                dp[i] = Math.max(nums[i] + sum,sum);
                sum = nums[i] + sum;
            }else {
                dp[i] = nums[i];
                sum = dp[i];
            }
        }
        int max = dp[0];
        for (int i = 1; i < len; i++){
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
