package DFSAndBackTrack;

import BinaryTree.Leetcode;

import java.util.*;

public class Leetcode_46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] used=new boolean[len];
        dfs(nums,res,path,0,used);
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> list :res){
            set.add(list);
        }
        return new LinkedList<>(set);
    }
    private void dfs(int[] nums,List<List<Integer>> res ,Deque<Integer> path,int depth,boolean[] used){
        if (depth==nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!used[i]){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(nums,res,path,depth+1,used);
                path.removeLast();
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        new Leetcode_46().permute(nums);
    }
}
