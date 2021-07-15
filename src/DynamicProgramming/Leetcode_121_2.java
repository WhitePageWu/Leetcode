package DynamicProgramming;

/**
 * @className: Leetcode_121_2
 * @description: TODO 股票问题1 三刷
 * @author: wuyurong
 * @date: 2021/7/14
 **/
public class Leetcode_121_2 {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];//0表示不持股；1表示持股
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1],- prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
