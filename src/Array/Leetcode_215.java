package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @className: Leetcode_215
 * @description: TODO 数组中第k个最大的元素
 * @author: wuyurong
 * @date: 2021/5/25
 **/
public class Leetcode_215 {
    /**
     *@描述 找到数组中第k大的元素。方法：快速排序排序+从后往前遍历
     *@参数 [int[], int]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
//方法一：        quickSort(nums)；
//方法二：jdk封装的排序就是快速排序
        Arrays.sort(nums);
        return nums[len-k];
    }
    //方法三：通过最小堆
    public int findKthLargestByMinHeap(int[] nums, int k){
        int len = nums.length;
        // 使用一个含有 len 个元素的最小堆，默认是最小堆，可以不写 lambda 表达式：(a, b) -> a - b
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> a - b);
        for (int i = 0; i < len; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public void quickSort(int[] nums){
        sort(nums,0,nums.length-1);
    }
    /**
     *@描述   对区间[left,right]之间的nums进行排序
     *@参数 [int[], int, int]
     *@返回值 void
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     */
    public void sort(int[] nums, int left, int right){
        if (left < right){
            int j = partition(nums,left,right);
            sort(nums,left,j-1);
            sort(nums,j+1,right);
        }
    }
    /**
     *@描述 将数组[left,right]区间的第一个元素放到排序应处位置。
     *@参数 [int[], int, int]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     */
    public int partition(int[] nums, int left, int right){
        int i = left, j = right+1;
        int temp = nums[left];
        while (true){
            while (nums[++i]<temp&&i!=right);
            while (nums[--j]>temp&&j!=left);
            if (i >= j){
                break;
            }
            int temp1 = nums[i];
            nums[i] = nums[j];
            nums[j] = temp1;
        }
        int temp2 = nums[left];
        nums[left] = nums[j];
        nums[j] = temp2;
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int res = new Leetcode_215().findKthLargestByMinHeap(nums,2);
        System.out.println(res);
    }
}
