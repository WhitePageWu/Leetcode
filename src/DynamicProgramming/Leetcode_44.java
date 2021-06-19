package DynamicProgramming;

/**
 * @className: Leetcode_44
 * @description: TODO 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 *
 * @author: wuyurong
 * @date: 2021/5/31
 **/
public class Leetcode_44 {
    public static boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 1; i <= len2; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1;i <= len1; i++){
            for (int j = 1;j <=len2; j++){
                if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                if (p.charAt(j-1) == s.charAt(i-1)||p.charAt(j-1) =='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        isMatch("aab","c*a*b");
    }
}
