package Array;
/**
 * @className: Leetcode_566
 * @description: TODO 矩阵重塑
 * @author: wuyurong
 * @date: 2021/7/15
 **/
public class Leetcode_566 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int r_len = mat.length;
        int c_len = mat[0].length;
        if (r_len*c_len != r*c){
            return mat;
        }
        int[][] ret = new int[r][c];
        for (int i = 0; i < r_len; i ++){
            for (int j = 0; j < c_len; j++){
                ret[(c_len*i+j)/c][(c_len*i+j)%c] = mat[i][j];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] nums = {{1,2},{3,4}};
        matrixReshape(nums,1,4);
    }
}
