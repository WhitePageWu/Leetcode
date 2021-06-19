package DynamicProgramming;

/**
 * @className: Leetcode_5_1
 * @description: TODO 最长回文子串二刷
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * @author: wuyurong
 * @date: 2021/6/2
 **/
public class Leetcode_5_1 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len==1){
            return s;
        }
        if (len == 2){
            return s.charAt(0)==s.charAt(1)?s:s.substring(0,1);
        }
        boolean[][] dp = new boolean[len][len];
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i <len; i++){
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if (s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j-i<3){     //长度为1,2,3。如：aba
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1>maxLen){
                    begin = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
