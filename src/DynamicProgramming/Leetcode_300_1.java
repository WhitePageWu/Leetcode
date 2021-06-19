package DynamicProgramming;

import java.util.Arrays;

/**
 * @className: Leetcode_300_1
 * @description: TODO 最长递增子序列二刷
 * @author: wuyurong
 * @date: 2021/6/14
 **/
public class Leetcode_300_1 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp,1);
        for (int i = 2; i <= len; i++){
            for (int j = 1; j < i; j++){
                if (nums[i-1]>nums[j-1]){
                    dp[i-1] = Math.max(dp[j-1]+1,dp[i-1]);
                }
            }
        }
        int max = 1;
        for (int x :dp){
            max = Math.max(max,x);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
