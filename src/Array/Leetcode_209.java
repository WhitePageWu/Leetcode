package Array;

//长度最小的字数组
public class Leetcode_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int max = Integer.MAX_VALUE;
        int start=0,end=0;
        int sum = 0;
        while (end<nums.length){
            sum+=nums[end];
            while (sum >= target) {
                max = Math.min(max, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return max == Integer.MAX_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,4};
        System.out.println(minSubArrayLen(5,arr));
    }
}
