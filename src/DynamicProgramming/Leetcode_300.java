package DynamicProgramming;

import java.util.Arrays;

//最长递增子序列
public class Leetcode_300 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = dp[0];
        for (int i = 1; i<len; i++){
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public static int longestSub(int[] nums){
        int len = nums.length;
        if (len<2){
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 0; i < len; i++){
            for (int j = 0; j < i; j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < len; i++){
            if (max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}
