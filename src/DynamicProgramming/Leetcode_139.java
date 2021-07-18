package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: Leetcode_139
 * @description: TODO 单词拆分
 * @author: wuyurong
 * @date: 2021/7/14
 **/
public class Leetcode_139 {
    //回溯法，超出时间限制
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        return dfs(s,"",wordDict,set);
    }
    public boolean dfs(String s, String sb, List<String> wordDict, Set set){
        if (sb.equals(s)){
            return true;
        }
        if (sb.length() > s.length()){
            return false;
        }
        for (int i = 0; i < wordDict.size(); i++){
            set.add(sb);
            if (dfs(s,sb+wordDict.get(i), wordDict, set)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(new Leetcode_139().wordBreak("applepenapple", wordDict));
    }
}
