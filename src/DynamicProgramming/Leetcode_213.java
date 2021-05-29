package DynamicProgramming;

/**
 * @className: Leetcode_213
 * @description: TODO 打家劫舍二:房屋连成一个环，收尾相邻
 * @author: wuyurong
 * @date: 2021/5/27
 **/
public class Leetcode_213 {
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len ==1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[len];
        //去掉最后一个房屋
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len-1; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int max1 = dp[len-2];
        //去掉第一个房屋
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1],nums[2]);
        for (int i = 2; i < len-1; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i+1]);
        }
        int max2 = dp[len-2];
        return Math.max(max1,max2);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        System.out.println(rob(nums));
    }
}
