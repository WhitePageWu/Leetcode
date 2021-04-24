package BFS;

import java.util.*;

public class Leetcode_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int list_num = wordList.size();
        int len = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                String word = queue.poll();
                if (word.equals(endWord)){
                    return step;
                }
                for (int j=0;j<len;j++){
                    char ch = word.charAt(j);
                    for (char k = 'a';k<='z';k++){
                        if (ch==k){
                            continue;
                        }
                        char[] wordch = word.toCharArray();
                        wordch[j]=k;
                        String str = new String(wordch);
                        if (!wordList.contains(str)){
                            continue;
                        }
                        if (!visited.contains(str)){
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }


    public static void main(String[] args) {
        String[] strs = {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"};
        List<String> wordList=new ArrayList<>();
        for (String str:strs){
            wordList.add(str);
        }
        new Leetcode_127().ladderLength("ymain","oecij",wordList);
    }
}
