package BackTrack;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_offer_38 {
    List<String> list = new LinkedList<>();
    public String[] permutation(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        backTrack(ch,sb);
        String[] ret = new String[list.size()];
        for (int i =0;i<ret.length;i++){
            ret[i]=list.get(i);
        }
        return ret;
    }
    public void backTrack(char[] ch,StringBuilder sb){
        if (sb.length()==ch.length){
            String str = sb.toString();
            if (!list.contains(str)){
                list.add(str);
            }
        }
        for (int i=0;i<ch.length;i++){
            sb.append(ch[i]);
            backTrack(ch,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        new Leetcode_offer_38().permutation("abc");
    }
}
