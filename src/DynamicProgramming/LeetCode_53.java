package DynamicProgramming;

public class LeetCode_53 {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];//pre为当前最大连续子序和，ans为结果
        for (int x : nums) {
            pre = Math.max(pre + x, x);//比较子序和加上x和x的值，若x值大，则重新计数
            maxAns = Math.max(maxAns, pre);//比较最大子序和和当前累加结果的大小，大者为新的最大子序和
        }
        return maxAns;
    }
}
