package DFSAndBackTrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: Leetcode_46_1
 * @description: TODO 全排列
 * @author: wuyurong
 * @date: 2021/5/30
 **/
public class Leetcode_46_1 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len];
        dfs(nums,path,0,used);
        return list;
    }
    public void dfs(int[] nums, Deque<Integer> path, int depth,boolean[] used){
        if (depth == nums.length){
            list.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,path,depth+1,used);
                used[i] =false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new Leetcode_46_1().permute(nums);
    }
}
