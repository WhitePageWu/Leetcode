package DynamicProgramming;

/**
 * @className: Leetcode_55
 * @description: TODO 跳跃游戏
 * @author: wuyurong
 * @date: 2021/7/14
 **/
public class Leetcode_55 {
    //二次便利
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return true;
        }
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len-1;i++){
            if (!dp[i]){
                break;
            }
            int max_step = nums[i];
            for (int j = 0; j < max_step; j++){
                if (i+j+1 < len){
                    dp[i+j+1] = true;
                }
            }
            if (dp[len-1]){
                return true;
            }
        }
        return dp[len-1];
    }
    //动归
    public static boolean canJump1(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return true;
        }
        boolean[] dp = new boolean[len];
        dp[len-1] = true;
        int latest = len-1;
        for (int i = len-2; i>=0; i--){
            if (i+nums[i] >= latest){
                dp[i] = true;
                latest = i;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] nums = {0,2,3};
        System.out.println(canJump1(nums));
    }
}
