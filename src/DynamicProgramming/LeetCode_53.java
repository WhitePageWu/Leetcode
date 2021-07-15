package DynamicProgramming;

//最大子序和
public class LeetCode_53 {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));
    }
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            ans = Math.max(ans+nums[i],nums[i]);
            res = Math.max(ans,res);
        }
        return res;
    }

    public static int maxSubArray1(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = dp[0];
        for (int i = 1; i<len;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
