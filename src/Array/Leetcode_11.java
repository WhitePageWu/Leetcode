package Array;

/**
 * @className: Leetcode_11
 * @description: TODO 盛最多的水
 * @author: wuyurong
 * @date: 2021/7/11
 **/
public class Leetcode_11 {
/*
    暴力破解，超时
    public static int maxArea(int[] height) {
        int max_square = Integer.MIN_VALUE;
        for (int i = 0; i < height.length-1; i++){
            for (int j = i+1; j <height.length; j++){
                int h = Math.min(height[i],height[j]);
                max_square = Math.max(max_square, h*(j-i));
            }
        }
        return max_square;
    }
*/
    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max_square = Integer.MIN_VALUE;
        while (left < right){
            int h = Math.min(height[left],height[right]);
            max_square = Math.max(max_square, h*(right-left));
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max_square;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
