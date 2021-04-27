package Array;

import java.util.Arrays;

//数组拆分。双指针专题
public class Leetcode_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int i =0;
        while (i<nums.length){
            sum+=nums[i];
            i=i+2;
        }
        return sum;
    }
}
