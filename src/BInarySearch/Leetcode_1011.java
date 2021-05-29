package BInarySearch;

import java.util.Arrays;

public class Leetcode_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights),right = getSum(weights)+1;
        while (left<right){
            int mid = left +(right-left)/2;
            if (canFinish(weights,D,mid)){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
    public boolean canFinish(int[] w,int D,int cap){
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length)
                    return true;
            }
        }
        return false;
    }
    int getMax(int[] weights){
        int max =0;
        for (int w:weights){
            max = Math.max(max,w);
        }
        return max;
    }
    int getSum(int[] weights){
        int sum = 0;
        for (int w:weights){
            sum+=w;
        }
        return sum;
    }
}
