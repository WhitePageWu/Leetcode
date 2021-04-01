package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        ArrayList<Integer> sublist = new ArrayList<>();
        dfs(nums,0,sublist,list);
        return list;
    }
    private void dfs(int[] nums,int start,ArrayList<Integer> sublist,List<List<Integer>> list){
        list.add(new ArrayList<>(sublist));
        for (int i = start;i<nums.length;i++){
            sublist.add(nums[i]);
            dfs(nums,i+1,sublist,list);
            sublist.remove(sublist.size()-1);
        }
    }

    public static void main(String[] args) {
        new Leetcode_78().subsets(new int[]{1,2,3});
        List<Integer> sublist = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(sublist);
        sublist.add(1);
    }
}
