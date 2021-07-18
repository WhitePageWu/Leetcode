package Array;

/**
 * @className: Leetcode_5814
 * @description: TODO 类描述
 * @author: wuyurong
 * @date: 2021/7/18
 **/
public class Leetcode_5814 {
    public static int addRungs(int[] rungs, int dist) {
        int len = rungs.length;
        int num = 0;
        for (int i = 0; i < rungs.length-1; i++){
            int diff = rungs[i+1] - rungs[i];
            if (diff <= dist){
                continue;
            }
            if (diff %dist ==0){
                num+=(diff/dist - 1);
            }else {
                num+=(diff/dist);
            }
        }
        int diff = rungs[0];
        if (diff > dist){
            if (diff %dist ==0){
                num+=(diff/dist - 1);
            }else {
                num+=(diff/dist);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {12,24};
        System.out.println(addRungs(nums,4));
    }
}
