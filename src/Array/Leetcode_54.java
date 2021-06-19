package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: Leetcode_54
 * @description: TODO 螺旋矩阵
 * @author: wuyurong
 * @date: 2021/5/30
 **/
public class Leetcode_54 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0){
            return list;
        }
        int n = matrix[0].length;
        traverse(matrix,0,n-1,0,m-1);
        return list;
    }
    public void traverse(int[][] matrix, int rowStart, int rowEnd,int colStart, int colEnd){
        if (rowEnd-rowStart<0||colEnd-colStart<0){
            return;
        }
        for (int i = rowStart;i <= rowEnd&&matrix[colStart][i]!=-101; i++){
            list.add(matrix[colStart][i]);
            matrix[colStart][i] = -101;
        }
        for (int i = colStart+1; i <= colEnd&&matrix[i][rowEnd]!=-101; i++){
            list.add(matrix[i][rowEnd]);
            matrix[i][rowEnd]=-101;
        }
        for (int i = rowEnd-1; i>=rowStart&&matrix[colEnd][i]!=-101;i--){
            list.add(matrix[colEnd][i]);
            matrix[colEnd][i]=-101;
        }
        for (int i = colEnd-1;i >=colStart+1&&matrix[i][rowStart]!=-101;i--){
            list.add(matrix[i][rowStart]);
            matrix[i][rowStart]=-101;
        }
        traverse(matrix,rowStart+1,rowEnd-1,colStart+1,colEnd-1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{5,6,7},{9,10,11}};
        new Leetcode_54().spiralOrder(matrix);
    }
}
