package DynamicProgramming;

//斐波那契数列
public class Leetcode_509 {
    public static int fib(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int fib1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(1));
    }
}
