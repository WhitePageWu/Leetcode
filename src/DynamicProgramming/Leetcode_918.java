package DynamicProgramming;

import java.util.Arrays;

/**
 * @className: Leetcode_918
 * @description: TODO 环形子数组的最大和
 * @author: wuyurong
 * @date: 2021/7/14
 **/
public class Leetcode_918 {
    public static int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[2*len-1];
        System.arraycopy(nums,0,newNums,0,len);
        System.arraycopy(nums,0,newNums,len,len-1);
        int[] dp = new int[2*len-1];
        dp[0] = newNums[0];
        for (int i = 1; i < newNums.length; i++){
            dp[i] = Math.max(dp[i-1]+newNums[i],newNums[i]);
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++){
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
