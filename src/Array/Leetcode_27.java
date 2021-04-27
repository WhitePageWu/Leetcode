package Array;

public class Leetcode_27 {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len==0){
            return 0;
        }
        int fast=0,slow=0;
        for (;fast<len;){
            if (nums[fast]==val){
                fast++;
            }else {
                nums[slow]=nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        removeElement(arr,2);
    }
}
