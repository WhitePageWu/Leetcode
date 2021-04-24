package DFSAndBackTrack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_216 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        Deque<Integer> path = new LinkedList<>();
        dfs(path,k,n,1);
        return res;
    }
    public void dfs(Deque<Integer> path,int k,int n,int depth){
        if (k==0&&n==0){
            res.add(new LinkedList<>(path));
            return;
        }
        if (k==0){
            return;
        }
        for (int i=depth;i<=9;i++){
            path.addLast(i);
            dfs(path,k-1,n-i,i+1);
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        new Leetcode_216().combinationSum3(3,9);
    }
}
