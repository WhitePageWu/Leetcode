package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @className: Leetcode_887
 * @description: TODO 鸡蛋掉落
 * @author: wuyurong
 * @date: 2021/5/26
 **/
public class Leetcode_887 {
    /**
     *@描述 k:鸡蛋个数,n楼层数[1,n]。返回鸡蛋最高承受楼层高度f
     *@参数 [int, int]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/26
     */
    public static int superEggDrop(int k, int n) {
        // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少仍的次数
        int[][] dp = new int[n + 1][k + 1];

        // 初始化
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], i);
        }
        //0层楼，任意个鸡蛋都是0
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 0;
        }

        dp[1][0] = 0;
        //1层楼1个以上鸡蛋只需1次
        for (int j = 1; j <= k; j++) {
            dp[1][j] = 1;
        }
        //0个鸡蛋为0，1个鸡蛋为楼层高度i
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 开始递推
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                // 在区间 [1, i] 里确定一个最优值
                int left = 1;
                int right = i;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;

                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop1(2,6));
    }
    /**
     *@描述 递归方法，用hash表减枝
     *@参数 [int, int]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/26
     */
    static HashMap<String,Integer> map = new HashMap<>();
    public static int superEggDrop1(int k, int n) {
        if (k == 1){
            return n;
        }
        if (n == 0){
            return 0;
        }
        if (map.containsKey(k+","+n)){
            return map.get(k+","+n);
        }
        int res = Integer.MAX_VALUE;
//        线性搜索
//        for (int i = 1; i <=n; i++){
//            res = Math.min(res,Math.max(superEggDrop1(k,n-i),superEggDrop1(k-1,i-1))+1);
//        }
        //采用二分法
        int left = 1,right = n;
        while (left<=right){
            int mid = left+(right-left)/2;
            int not_broken = superEggDrop1(k,n-mid);
            int broken = superEggDrop1(k-1,mid-1);
            if (broken>not_broken){
                right = mid -1;
                res = Math.min(res,broken+1);
            }else {
                left = mid + 1;
                res = Math.min(res,not_broken+1);
            }
        }
        map.put(k+","+n,res);
        return res;
    }

}
