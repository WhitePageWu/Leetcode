package DFSAndBackTrack;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_784 {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(new StringBuilder(S),0);
        return res;
    }
    public void dfs(StringBuilder s,int index){
        if (index==s.length()){
            res.add(s.toString());
            return;
        }
        char c = s.charAt(index);
        if ((c-'a'>=0&&c-'z'<=0)||(c-'A'>=0&&c-'Z'<=0)){
            dfs(s,index+1);
            s.setCharAt(index,(char)(c ^ 32));
            dfs(s,index+1);
        }else {
            dfs(s,index+1);
        }
    }

    public static void main(String[] args) {
        new Leetcode_784().letterCasePermutation("a1B2");
    }
}
