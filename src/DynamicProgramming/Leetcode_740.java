package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: Leetcode_740
 * @description: TODO 最大点数和
 * @author: wuyurong
 * @date: 2021/7/12
 **/
public class Leetcode_740 {
    public static int deleteAndEarn(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : nums){
            if (x < min){
                min = x;
            }
            if (x > max){
                max = x;
            }
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int[] dp = new int[max - min + 1];
        dp[0] = map.get(min)*min;
        dp[1] = Math.max(map.getOrDefault(min+1,0)*(min+1),dp[0]);
        for (int i = 2; i < dp.length; i++){
            int cur = map.getOrDefault(min+i,0)*(min+i);
            dp[i] = Math.max(dp[i-1],dp[i-2]+cur);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }
}
