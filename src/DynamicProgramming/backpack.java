package DynamicProgramming;

/**
 * @className: backpack
 * @description: TODO 类描述
 * @author: wuyurong
 * @date: 2021/7/18
 **/
public class backpack {
    public static void main(String[] args) {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int[][] dp = new int[3][6];
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        /*
        正序初始化是不行的
        for (int j = weights[0]; j <= 4; j++){
            dp[0][j] = dp[0][j - weights[0]] + values[0];
        }
        */
//        for (int j = 4; j >= weights[0]; j--){
//            dp[0][j] = dp[0][j-weights[0]] + values[0];
//        }
        for (int j = weights[0]; j < 6; j++){
            dp[0][j] = values[0];
        }
        for (int i = 1; i < weights.length; i++){
            for (int j = 0; j <=5; j++){
                if (j < weights[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
                }
            }
        }

        System.out.println();
    }
}
