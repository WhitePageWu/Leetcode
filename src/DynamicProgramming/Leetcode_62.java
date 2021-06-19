package DynamicProgramming;

import java.util.Arrays;

/**
 * @className: Leetcode_62
 * @description: TODO 不同路径
 * @author: wuyurong
 * @date: 2021/6/10
 **/
public class Leetcode_62 {
    /**
     *@描述
     *@参数 [m, n]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/6/10
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            dp[i][n-1] = 1;
        }
        Arrays.fill(dp[m-1],1);
        for (int i =1; i <m; i++){
            for (int j = 1; j < n; j++){
                dp[m-1-i][n-1-j] = dp[m-1-i][n-j]+dp[m-i][n-1-j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}
