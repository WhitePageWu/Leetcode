package DynamicProgramming;

/**
 * @className: Leetcode_122_2
 * @description: TODO 股票问题二2刷
 * @author: wuyurong
 * @date: 2021/7/16
 **/
public class Leetcode_122_2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[dp.length-1][0];
    }
}
