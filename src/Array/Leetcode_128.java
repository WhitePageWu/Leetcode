package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Leetcode_128
 * @description: TODO 最长连续序列
 * @author: wuyurong
 * @date: 2021/7/12
 **/
public class Leetcode_128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>(); // 记录区间 [v, r]
        for (int v : nums) map.put(v, v);

        int max = 1;
        for (int v : nums) {
            int r = v;
            while (map.containsKey(r + 1)) {
                r = map.get(r + 1); // 利用前面已知的右边界，快速找到当前需要的右边界
                map.remove(r);
            }
//            map.put(v, r);
            max = Math.max(max, r - v + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999};
        System.out.println(longestConsecutive(nums));
    }
}
