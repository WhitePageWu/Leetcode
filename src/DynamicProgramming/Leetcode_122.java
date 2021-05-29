package DynamicProgramming;

public class Leetcode_122 {
    public static int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len<2){
            return 0;
        }
        int cash = 0;
        int hold = -prices[0];
        int precash = cash;
        int prehold = hold;
        for (int i = 1; i < len; i++){
            cash = Math.max(precash,prehold+prices[i]);
            hold = Math.max(prehold,precash-prices[i]);
            precash = cash;
            prehold = hold;
        }
        return cash;
    }
}
