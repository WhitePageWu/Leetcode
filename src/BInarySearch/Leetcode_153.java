package BInarySearch;

/**
 * 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Leetcode_153 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }
        int left =0,right = n-1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (left<=right){

            int mid = left+((right-left)>>1);
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if (nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if (nums[mid]>nums[left]){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
}
