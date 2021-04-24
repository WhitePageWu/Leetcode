package DFSAndBackTrack;

import java.util.ArrayList;
import java.util.List;

//括号生成
public class Leetcode_22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("",n,n);
        return res;
    }
    public void dfs(String cur,int left,int right){
        if (right<left){
            return;
        }
        if (left==0&&right==0){
            res.add(cur);
            return;
        }
        if (left!=0){
            dfs(cur+"(",left-1,right);
        }
        if (right!=0){
         dfs(cur+")",left,right-1);
        }
    }

    public static void main(String[] args) {
        new Leetcode_22().generateParenthesis(3);
    }
}
