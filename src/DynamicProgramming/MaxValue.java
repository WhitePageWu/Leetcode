package DynamicProgramming;

/**
 * @className: MaxValue
 * @description: TODO 0/1背包问题
 * @author: wuyurong
 * @date: 2021/6/17
 **/
public class MaxValue {
    public static int maxValue(int v, int[] weights,int[] value){
        int size = weights.length;
        int[][] dp = new int[size][v+1]; //dp[i][j] 表示从下标为[0-i]的物品⾥任意取，放进容量
                                            //为j的背包，价值总和最⼤是多少。
        for (int i = 0; i < size; i++){
            dp[i][0] = 0;
        }
        for (int j = v; j>=weights[0];j--){
            dp[0][j] = dp[0][j - weights[0]] + value[0];
        }
        for (int i = 1; i < size; i++){
            for (int j = 0; j <=v;j++){
                if (j<weights[i]){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+value[i]);
                }
            }
        }
        return dp[size-1][v];
    }

    public static int maxValue1(int v, int[] weights,int[] value){
        int size = weights.length;
        int[] dp = new int[v+1];
        for (int i = 0; i <weights.length; i++){
            for (int j = v; j >=weights[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-weights[i]]+value[i]);
            }
        }
        return dp[v];
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        System.out.println(maxValue1(4,weights,values));
    }
}
