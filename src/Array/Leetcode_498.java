package Array;

public class Leetcode_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[] ret = new int[M*N];//数组长度
        int index = 0;
        boolean flag =false ;
        int i=0,j=0;
        ret[0]=mat[0][0];
        while (N==1&&index<M-1){
            index++;
            ret[index]=mat[++i][j];
        }
        while (M==1&&index<N-1){
            index++;
            ret[index]=mat[i][++j];
        }
        while (index<ret.length-1){
            int i_j = i+j;
            if (i==0&&j==0){//左上角
                j++;
            }else if ((i==0||i==M-1)&&(j!=N-1)&&flag){
                j++;
                flag = false;
            }else if ((j==0||j==N-1)&&(i!=M-1)&&flag){
                i++;
                flag=false;
            }else {
                flag=true;
                if (i_j%2==0&&(i!=0)&&(j!=N-1)){
                    i--;
                    j++;
                }else if (i_j%2!=0&&(i!=M-1)&&(j!=0)){
                    i++;
                    j--;
                }
            }
            index++;
            ret[index]=mat[i][j];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new Leetcode_498().findDiagonalOrder(mat);
    }
}
