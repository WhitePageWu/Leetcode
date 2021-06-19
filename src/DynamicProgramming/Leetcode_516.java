package DynamicProgramming;

/**
 * @className: Leetcode_516
 * @description: TODO 最长回文子序列
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * @author: wuyurong
 * @date: 2021/6/2
 **/
public class Leetcode_516 {
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--){
            dp[i][i] = 1;
            for (int j = i+1; j < len; j ++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        longestPalindromeSubseq("cbbdd3");
    }
}
