package DynamicProgramming;

/**
 * @className: Leetcode_121_1
 * @description: TODO 股票1 二刷
 * @author: wuyurong
 * @date: 2021/5/28
 **/
public class Leetcode_121_1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        if (len<2){
            return 0;
        }
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i ++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[len-1][0];
    }
}
