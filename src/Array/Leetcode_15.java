package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @className: Leetcode_15
 * @description: TODO 三数之和
 * @author: wuyurong
 * @date: 2021/5/27
 **/
public class Leetcode_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        int len = nums.length;
        if (len<3){
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i]>0){
                return list;
            }
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R){
                if (nums[i]+nums[L]+nums[R] == 0){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);subList.add(nums[L]);subList.add(nums[R]);
                    list.add(subList);
                    while(L<R && nums[L]==nums[L+1]) L=L+1;
                    while(L<R && nums[R]==nums[R-1]) R=R-1;
                    L = L + 1;
                    R = R - 1;
                }else if(nums[i]+nums[L]+nums[R]>0){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
