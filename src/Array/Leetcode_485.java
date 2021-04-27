package Array;

public class Leetcode_485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int len = nums.length;
        int max = 0;
        int start=0,end=0;
        while (end<len){
            if (nums[end]==1){
                end++;
            }else {
                max=Math.max(max,end-start);
                end++;
                start=end;
            }
        }
        return Math.max(max,end-start);
    }

    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
