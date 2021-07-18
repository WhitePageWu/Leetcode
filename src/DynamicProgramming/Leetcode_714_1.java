package DynamicProgramming;

/**
 * @className: Leetcode_714_1
 * @description: TODO 股票问题手续费二刷
 * @author: wuyurong
 * @date: 2021/7/17
 **/
public class Leetcode_714_1 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[dp.length-1][0];
    }
}
