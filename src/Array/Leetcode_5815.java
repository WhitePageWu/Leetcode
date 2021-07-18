package Array;

import java.util.Arrays;
import java.util.Map;

/**
 * @className: Leetcode_5815
 * @description: TODO 类描述
 * @author: wuyurong
 * @date: 2021/7/18
 **/
public class Leetcode_5815 {
    int res = Integer.MIN_VALUE;
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        dfs(points,0,0,0);
        return res;
    }
    public void dfs(int[][] points, int r,int pre , int sum){
        if (r == points.length){
            res = Math.max(res, sum);
            return;
        }
        for (int i = 0; i < points[0].length; i++){
            if (r == 0){
                pre = i;
            }
            int temp = points[r][i];
            dfs(points,r+1,i,sum+temp - Math.abs(i-pre));
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1},{1},{1},{1},{1}};
        System.out.println(new Leetcode_5815().maxPoints1(mat));;
    }
    public long maxPoints1(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for (int i = 0; i < n; i++){
            dp[0][i] = points[0][i];
        }
        for (int r = 1; r < m; r++){
             for (int c = 0; c < n; c++){
                 for (int d = 0; d < n; d++){
                     dp[r][c] = Math.max(dp[r][c],dp[r-1][d]+points[r][c]-Math.abs(c-d));
                 }
             }
        }
        long max = dp[m-1][0];
        for (long x : dp[m-1]){
            max = Math.max(max,x);
        }
        return max;
    }
}
