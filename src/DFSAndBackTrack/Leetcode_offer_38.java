package DFSAndBackTrack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_offer_38 {
    /**此方法超出时间限制
    List<String> list = new LinkedList<>();
    public String[] permutation(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] used =  new boolean[ch.length];
        Arrays.sort(ch);
        backTrack(ch,sb,used);
        String[] ret = new String[list.size()];
        for (int i =0;i<ret.length;i++){
            ret[i]=list.get(i);
        }
        return ret;
    }
    public void backTrack(char[] ch,StringBuilder sb,boolean[] used){
        if (sb.length()==ch.length){
            String str = sb.toString();
            if (!list.contains(str)){
                list.add(str);
            }
            return;
        }
        for (int i=0;i<ch.length;i++){
            if (used[i]){
                continue;
            }
            if (i > 0 && ch[i] == ch[i - 1] && !used[i - 1]){
                continue;
            }
            sb.append(ch[i]);
            used[i]=true;
            backTrack(ch,sb,used);
            used[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
*/
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        new Leetcode_offer_38().permutation("aba");
    }
}
