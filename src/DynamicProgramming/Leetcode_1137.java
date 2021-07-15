package DynamicProgramming;

/**
 * @className: Leetcode_1137
 * @description: TODO 类描述
 * @author: wuyurong
 * @date: 2021/7/11
 **/
public class Leetcode_1137 {
    public static int tribonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n < 3){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;dp[1]=1;dp[2]=1;
        for (int i = 3; i < dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));

    }
}
