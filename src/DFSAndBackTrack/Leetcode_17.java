package DFSAndBackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_17 {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return res;
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(map,digits,0,new StringBuilder());
        return res;
    }
    public void dfs(Map<Character,String> map,String digits,int index,StringBuilder sb){
        if (index==digits.length()){
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        String str = map.get(digit);
        int len = str.length();
        for (int i=0;i<len;i++){
            sb.append(str.charAt(i));
            dfs(map,digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        new Leetcode_17().letterCombinations("23");
    }
}
