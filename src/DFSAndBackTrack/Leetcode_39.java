package DFSAndBackTrack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Deque selected = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates,res,selected,target,0,0);
        return res;
    }
    private void dfs(int[] candidates,List<List<Integer>> res,Deque selectd,int target,int sum,int begin){
        if (target==sum){
            res.add(new LinkedList<>(selectd));
            return;
        }
        for (int i=begin;i<candidates.length;i++){
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum+candidates[i]>target){
                return;
            }
            selectd.addLast(candidates[i]);
            dfs(candidates,res,selectd,target,sum+candidates[i],i);
            selectd.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidate = {2,3,6,7};
        new Leetcode_39().combinationSum(candidate,7);
    }
}
