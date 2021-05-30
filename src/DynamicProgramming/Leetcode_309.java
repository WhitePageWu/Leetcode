package DynamicProgramming;

/**
 * @className: Leetcode_309
 * @description: TODO 买卖股票问题5 含冷冻期，卖了股票第二天不能进行买入。
 * @author: wuyurong
 * @date: 2021/5/29
 **/
public class Leetcode_309 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<2){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1] = Math.max(dp[0][1],dp[0][0]-prices[1]);
        for (int i = 2; i<len;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
