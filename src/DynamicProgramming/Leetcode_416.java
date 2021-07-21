package DynamicProgramming;

import java.util.Arrays;

/**
 * @className: Leetcode_416
 * @description: TODO 分割等和子集
 * @author: wuyurong
 * @date: 2021/6/19
 **/
public class Leetcode_416 {
    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int x:nums){
            sum+=x;
        }
        boolean[] used = new boolean[nums.length];
        return dfs(nums,used,sum/2,0);
    }
    //方法一，回溯法
    public static boolean dfs(int[] nums, boolean[] used, int total, int cur){
        if (cur == total){
            return true;
        }
        if (cur > total){
            return false;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i]==false){
                used[i] = true;
                if (dfs(nums,used,total,cur+nums[i])){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
    //动态规划
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x:nums){
            sum+=x;
        }
        if (sum%2!=0){
            return false;
        }
        int[][] dp = new int[nums.length][sum/2+1];//dp[i][j]表示背包容量为j，前i个数可得到的最大子集
        for (int i = 0; i < nums.length; i++){
            dp[i][0] = 0;
        }
        for (int i = sum/2; i >= nums[0]; i--){
            dp[0][i] = dp[0][i-nums[0]]+nums[0];
        }
       for (int i = 1; i < nums.length;i++){
           for (int j = 0 ; j <= sum/2; j++){
               if (j<nums[i]){
                   dp[i][j] = dp[i-1][j];
               }else {
                   dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
               }
           }
       }
       if (dp[nums.length-1][sum/2] == sum/2){
           return true;
       }
       return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(canPartition(nums));;
    }
}
