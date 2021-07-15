package Array;

import java.util.Arrays;

/**
 * @className: Leetcode_31
 * @description: TODO 下一个排列
 * @author: wuyurong
 * @date: 2021/7/11
 **/
public class Leetcode_31 {
    public static void nextPermutation(int[] nums) {
        //先判断是否已经是最大序列了
        boolean isMax = true;
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] < nums[i+1]){
                isMax = false;
                break;
            }
        }
        if (!isMax){//目前还不是最大序列
            int j =0;
            for (int i = nums.length - 1; i > 0; i--){
                if (nums[i] > nums[i-1]){
                    j = i-1;
                    break;
                }
            }
            for (int i = nums.length-1; i > j; i--){
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
            Arrays.sort(nums,j+1,nums.length);
        }else {
            int left = 0;
            int right = nums.length - 1;
            while (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        nextPermutation(nums);
        System.out.println();
    }
}
