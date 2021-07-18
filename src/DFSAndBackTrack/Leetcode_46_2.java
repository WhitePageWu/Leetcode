package DFSAndBackTrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: Leetcode_46_2
 * @description: TODO 全排列三刷
 * @author: wuyurong
 * @date: 2021/7/16
 **/
public class Leetcode_46_2 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,deque,used);
        return list;
    }
    public void dfs(int[] nums, int depth, Deque<Integer> deque, boolean[] used){
        if (depth == nums.length){
            list.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!used[i]){
                deque.addLast(nums[i]);
                used[i] = true;
                dfs(nums,depth+1,deque,used);
                used[i] = false;
                deque.removeLast();
            }
        }
    }
}
