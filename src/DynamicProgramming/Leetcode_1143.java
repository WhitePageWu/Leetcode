package DynamicProgramming;

/**
 * @className: Leetcode_1143
 * @description: TODO 最长公共子序列
 * @author: wuyurong
 * @date: 2021/5/25
 **/
public class Leetcode_1143 {
    /**
     *@描述 求解两个字符串的最长公共子序列
     *@参数 [text1, text2]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     *@修改人和其它信息
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1==0||len2==0){
            return 0;
        }
        int[][] dp = new int[len1+1][len2+1]; //dp[i][j]表示text1【0,...,i]和text2[0,...,j]的最长公共子串
        for (int i = 1; i<= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc","def"));
    }

}
