package DynamicProgramming;

/**
 * @className: Leetcode_343
 * @description: TODO 类描述
 * @author: wuyurong
 * @date: 2021/6/14
 **/
public class Leetcode_343 {
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i < n+1; i++){
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),dp[i-j]*j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
