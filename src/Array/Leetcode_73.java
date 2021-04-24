package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组置0
 * */
public class Leetcode_73 {
    public void setZeroes(int[][] matrix) {
        Set<String> set = new HashSet<>();
        for (int i =0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    set.add(i+","+j);
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0&&set.contains(i+","+j)){
                    setZero(matrix,i,j);
                }
            }
        }
    }
    public void setZero(int[][] matrix,int i,int j){
        for (int row =0;row<matrix.length;row++){
            matrix[row][j]=0;
        }
        for (int col=0;col<matrix[i].length;col++){
            matrix[i][col]=0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Leetcode_73().setZeroes(matrix);
        System.out.println();
    }
}
