package DynamicProgramming;

/**
 * @className: Leetcode_714
 * @description: TODO 股票问题。每次交易需要支付fee元手续费。
 * @author: wuyurong
 * @date: 2021/5/29
 **/
public class Leetcode_714 {
    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len<2){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //每次卖出股票支付手续费
        for (int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices,2));
    }
}
