package DynamicProgramming;

/**
 * @className: Leetcode_63
 * @description: TODO 不同的路径2
 * @author: wuyurong
 * @date: 2021/6/11
 **/
public class Leetcode_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++){
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i <width; i++){
            if (obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i <height; i++){
            for (int j = 0; j < width; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    break;
                }
            }
        }
        for (int i = 1; i < height; i++){
            for (int j = 1; j <width; j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[height-1][width-1];
    }

    public static void main(String[] args) {
        int[][] obstacle = {{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacle));
    }
}
