package BInarySearch;

/**
 * @className: Leetcode_69_1
 * @description: TODO 完全平方数
 * @author: wuyurong
 * @date: 2021/6/25
 **/
public class Leetcode_69_1 {
    public int mySqrt(int x) {
        if (x == 0|| x == 1){
            return x;
        }
        int left = 1,right = x/2;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (x/mid == mid){
                return mid;
            }else if (x / mid < mid){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
