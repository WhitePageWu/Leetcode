package DynamicProgramming;

/**
 * @className: Leetcode_416_1
 * @description: TODO 分割等和子集
 * @author: wuyurong
 * @date: 2021/7/19
 **/
public class Leetcode_416_1 {
    //1。 0/1背包
    public static boolean canPartition(int[] nums) {
        int all_weights = 0;
        for (int x : nums){
            all_weights += x;
        }
        int[][] dp = new int[nums.length][all_weights/2+1];
        for (int j = all_weights/2; j >= nums[0]; j--){
            dp[0][j] = dp[0][j-nums[0]] + nums[0];
        }
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j <= all_weights/2; j++){
                if (j < nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j- nums[i]] + nums[i]);
                }
            }
        }
        if (dp[nums.length-1][all_weights/2] == all_weights/2.0){
            return true;
        }
        return false;
    }
    //2. 滚动数组
    public static boolean canPartition1(int[] nums) {
        int all_weights = 0;
        for (int x : nums){
            all_weights += x;
        }
        if (all_weights % 2 != 0){
            return false;
        }
        int[] dp = new int[all_weights/2 + 1];
        for (int j = all_weights/2; j >= nums[0]; j--){
            dp[j] = dp[j-nums[0]] + nums[0];
        }
        for (int i = 1; i < nums.length; i++){
            for (int j = all_weights/2; j >=nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[all_weights/2] == all_weights/2;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition1(nums));
    }
}
