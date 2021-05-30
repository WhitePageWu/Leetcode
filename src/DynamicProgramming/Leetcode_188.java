package DynamicProgramming;

/**
 * @className: Leetcode_188
 * @description: TODO 股票问题4 最多可以发生k次交易
 * @author: wuyurong
 * @date: 2021/5/28
 **/
public class Leetcode_188 {
    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        if (k>len/2){
            return maxProfitNoLimit(prices);
        }
        int[][][] dp = new int[len][k+1][2];
        for (int i = 1; i<=k;i++){
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++){
            for (int j = 1; j <= k; j++){
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                dp[i][j][0] = Math.max(dp[i-1][j][1]+prices[i],dp[i-1][j][0]);
            }
        }
        return dp[len-1][k][0];
    }
    public static int maxProfitNoLimit(int[] prices) {
        int len = prices.length;
        if (len<2){
            return 0;
        }
        int [][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }

    public static int maxProfit1(int k, int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        if (k>len/2){
            return maxProfitNoLimit(prices);
        }
        int[][] dp = new int[k+1][2];
        for (int j = 0; j <= k; j++){
            dp[j][1] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - price);
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + price);
            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit1(2,prices));
    }
}
