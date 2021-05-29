package DynamicProgramming;

/**
 * @className: Leetcode_123
 * @description: TODO 股票问题3 最多只能完成两笔交易
 * @author: wuyurong
 * @date: 2021/5/28
 **/
public class Leetcode_123 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        //dp[i][j][k]表示截止第i天，发生了j次交易，k表示持不持股。
        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;//什么也不做
        dp[0][1][1] = -prices[0]; //发生一次交易，持股，所以-price[0]
        dp[0][2][1] = Integer.MIN_VALUE;//还没发生交易
        for (int i = 1; i < len; i++){
            dp[i][1][1] = Math.max(-prices[i],dp[i-1][1][1]);
            dp[i][1][0] = Math.max(dp[i-1][1][1]+prices[i],dp[i-1][1][0]);
            dp[i][2][1] = Math.max(dp[i-1][2][1],dp[i-1][1][0]-prices[i]);
            dp[i][2][0] = Math.max(dp[i-1][2][1]+prices[i],dp[i-1][2][0]);
        }
        return Math.max(dp[len-1][1][0],dp[len-1][2][0]);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(maxProfit(nums));
    }
}
