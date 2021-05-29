package Array;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

//滑动窗口最大值
public class Leetcode_239 {
    //双向队列
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null){
            return null;
        }
        int len = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[len - k + 1];
        int index = 0;
        for (int i = 0;i < len; i++){
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]){
                list.pollLast();
            }
            list.addLast(i);
            if (list.peekFirst() == i - k){
                list.pollFirst();
            }
            if (i >= k -1){
                res[index++] = nums[list.peekFirst()];
            }
        }
        return res;
    }
    //优先级队列
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        maxSlidingWindow1(arr,3);
    }
}
