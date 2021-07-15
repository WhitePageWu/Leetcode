package Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @className: Leetcode_350
 * @description: TODO 两个数组的交集
 * @author: wuyurong
 * @date: 2021/7/14
 **/
public class Leetcode_350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums1){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (int x : nums2){
            if (map.containsKey(x)){
                list.add(x);
                int temp = map.get(x);
                if (temp == 1){
                    map.remove(x);
                    continue;
                }
                map.put(x,map.get(x)-1);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersect(nums1, nums2);
    }
}
