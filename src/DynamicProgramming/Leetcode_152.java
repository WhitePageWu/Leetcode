package DynamicProgramming;

/**
 * @className: Leetcode_152
 * @description: TODO 乘积最大子数组
 * @author: wuyurong
 * @date: 2021/5/25
 **/
public class Leetcode_152 {
    /**
     *@描述   求解子数组中乘积最大的数，动态规划
     *@参数 [int[]]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     */
    public static int maxProducts(int[] nums){
        int len = nums.length;
        int[] maxF = new int[len];
        int[] minF = new int[len];
        System.arraycopy(nums,0,maxF,0,len);
        System.arraycopy(nums,0,minF,0,len);
        for (int i = 1; i < len; i ++){
            maxF[i] = Math.max(nums[i]*maxF[i-1],Math.max(nums[i],minF[i-1]*nums[i]));
            minF[i] = Math.min(nums[i]*minF[i-1],Math.min(nums[i],maxF[i-1]*nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < len; i++){
            ans = Math.max(ans,maxF[i]);
        }
        return ans;
    }

    /**
     *@描述 动态规划_空间优化
     *@参数 [int[]]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     */
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for (int i = 1; i < len; i ++){
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i],Math.max(nums[i],mn*nums[i]));
            minF = Math.min(mn*nums[i],Math.min(nums[i],mx*nums[i]));
            ans = Math.max(maxF,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProducts(nums));
    }
}
