package Array;

/**
 * @className: Leetcode_1014
 * @description: TODO 最佳观光组合
 * @author: wuyurong
 * @date: 2021/7/16
 **/
public class Leetcode_1014 {
    public static int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        if (len == 2){
            return values[0]+values[1]-1;
        }
        int[] dp = new int[values.length];
        dp[0] = 0;
        dp[1] = values[0]+values[1]-1;
        int i = 0,j = 1;
        for (int k = 2; k < dp.length; k++){
            int res1 = values[k] - values[i] +2*j - i - k;
            int res2 = values[k] - values[j] - (k-j);
            if (res1 <= 0 && res2 <= 0){
                dp[k] = dp[k-1];
                continue;
            }
            if (res1 >= res2){
                i = j;
                j = k;
                dp[k] = values[i] +values[j] + i -k;
            }else {
                j = k;
                dp[k] = values[i] +values[j] + i -k;
            }
        }
        int max = dp[0];
        for (int k = 1; k < dp.length; k++){
            max = Math.max(max,dp[k]);
        }
        return max;
    }
    public static int maxScoreSightseeingPair1(int[] values) {
        int len = values.length;
        if (len == 2){
            return values[0]+values[1]-1;
        }
        int[] dp = new int[values.length];
        dp[0] = 0;
        dp[1] = values[0]+values[1]-1;
        int max = Math.max(values[0],values[1]+1);
        for (int j = 2; j < dp.length; j++){
            dp[j] = Math.max(dp[j-1], max+values[j]-j);
            max = Math.max(max,values[j]+j);
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        int[] values = {7,8,8,10};
        System.out.println(maxScoreSightseeingPair1(values));
    }
}

