package DFSAndBackTrack;

import java.util.*;

/**
 * @className: Leetcode_47
 * @description: TODO 全排列2
 * @author: wuyurong
 * @date: 2021/7/16
 **/
public class Leetcode_47 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, deque,0, used);
        return list;
    }
    public void dfs(int[] nums, Deque<Integer> deque, int depth, boolean[] used){
        if (depth == nums.length){
            list.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            //判断当前值和刚刚退出的是否相同，相同则剪枝
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            deque.addLast(nums[i]);
            used[i] = true;
            dfs(nums, deque, depth+1, used);
            used[i] = false;
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        new Leetcode_47().permuteUnique(nums);
    }
}
