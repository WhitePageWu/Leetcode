package Array;

/**
 * @className: Leetcode_4
 * @description: TODO 两个数组的中位数
 * @author: wuyurong
 * @date: 2021/7/11
 **/
public class Leetcode_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length;
        int len = len1+len2;
        int[] arr = new int[len];
        int i = 0 , j = 0;
        int cur = 0;
        while (cur<len){
            if (i!=len1&&j!=len2){
                if (nums1[i] < nums2[j]){
                    arr[cur++] = nums1[i++];
                }else {
                    arr[cur++] = nums2[j++];
                }
                continue;
            }
            if (i!=len1){
                arr[cur++] = nums1[i++];
                continue;
            }
            if (j!=len2){
                arr[cur++] = nums2[j++];
                continue;
            }
        }
        if (len%2==0){
            return (arr[(len-1)/2]+arr[(len-1)/2+1])/2.0;
        }else {
            return arr[(len-1)/2];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {};
        int[] num2 = {2};
        System.out.println(findMedianSortedArrays(num1,num2));
    }
}
