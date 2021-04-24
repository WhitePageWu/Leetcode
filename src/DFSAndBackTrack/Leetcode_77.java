package DFSAndBackTrack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_77 {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums =new int[n];
        for (int i=1;i<=n;i++){
            nums[i-1]=i;
        }
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(nums,res,path,0,k);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path,int depth,int k){
        if (path.size()==k){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i=depth;i<nums.length;i++){
            path.addLast(nums[i]);
            dfs(nums,res,path,i+1,k);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        new Leetcode_77().combine(4,2);
    }
}
