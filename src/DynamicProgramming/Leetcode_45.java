package DynamicProgramming;

import java.util.Arrays;

/**
 * @className: Leetcode_45
 * @description: 跳跃游戏二
 * @author: wuyurong
 * @date: 2021/7/14
 **/
public class Leetcode_45 {
    public static int jump(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i =0; i <len; i++){
            int max_step = nums[i];
            for (int j = nums[i]; j > 0; j--){
                if (i+j < len) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
            if (dp[len-1]!=Integer.MAX_VALUE){
                return dp[len-1];
            }
        }
        return dp[len-1];
    }
    public static int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump2(nums));
    }
}
