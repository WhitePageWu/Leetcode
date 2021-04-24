package DFSAndBackTrack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums,res,path,0);
        return res;
    }
    private void dfs(int[] nums,List<List<Integer>> res,Deque<Integer> path,int depth){
        res.add(new LinkedList<>(path));
        for (int i=depth;i<nums.length;i++){
            if (i>depth&&nums[i]==nums[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            dfs(nums,res,path,i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,2};
        new Leetcode_90().subsetsWithDup(nums);
    }
}
