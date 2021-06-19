package DynamicProgramming;

import java.util.Arrays;

/**
 * @className: Leetcode_953
 * @description: TODO 骑士拨号器
 * @author: wuyurong
 * @date: 2021/6/10
 **/
public class Leetcode_953 {
    public static int knightDialer(int n) {
        int MOD = 1_000_000_007;
        int[][] moves = new int[][]{
                {4,6},{6,8},{7,9},{4,8},{3,9,0},
                {},{1,7,0},{2,6},{1,3},{2,4}};
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0],1);
        for (int i = 1; i < n; i++){
            for (int j = 0; j < 10; j++){
                for (int arrive:moves[j]){
                    dp[i][j] = (dp[i][j]+dp[i-1][arrive]) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++){
            res = (res+dp[n-1][i]) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(knightDialer(3));
    }
}
