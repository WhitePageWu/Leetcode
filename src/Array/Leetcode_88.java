package Array;

/**
 * @className: Leetcode_88
 * @description: TODO 合并数组
 * @author: wuyurong
 * @date: 2021/5/28
 **/
public class Leetcode_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length-1;
        m--;
        n--;
        while (n>=0){
            while (m>=0&&nums1[m]>nums2[n]){
                nums1[i--] = nums1[m--];
            }
            nums1[i--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        merge(nums1,1,nums2,1);
    }
}
