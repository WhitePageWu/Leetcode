package Array;

public class Leetcode_724 {
    public static int pivotIndex(int[] nums) {
        int sum =0;
        for (int x:nums){
            sum+=x;
        }
        int index = 0;
        int cur =0;
        while (index<nums.length){
            if (cur*2==sum-nums[index]){
                return index;
            }
            cur+=nums[index];
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,2};
        System.out.println( pivotIndex(nums));
    }
}
