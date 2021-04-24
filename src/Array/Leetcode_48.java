package Array;

public class Leetcode_48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //转置
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){
                if (i==j){
                    continue;
                }
                int temp =matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //镜像反转
        for (int i=0;i<len/2;i++){
            for (int j=0;j<len;j++){
                int temp = matrix[j][i];
                matrix[j][i]=matrix[j][len-i-1];
                matrix[j][len-i-1]=temp;
            }
        }
    }
}
