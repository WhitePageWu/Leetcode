package DFSAndBackTrack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        Deque path = new LinkedList();
        dfs(candidates,res,path,0,target);
        return res;
    }
    private void dfs(int[]candidates,List<List<Integer>> res,Deque path,int depth,int target){
        if (target==0){
            res.add(new LinkedList<>(path));
            return;
        }
        if (target<0||depth==candidates.length){
            return;
        }
        for (int i=depth;i<candidates.length;i++){
            if (i > depth && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates,res,path,i+1,target-candidates[i]);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates ={2,5,2,1,2};
        new Leetcode_40().combinationSum2(candidates,5);
    }
}
