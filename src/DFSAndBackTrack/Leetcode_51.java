package DFSAndBackTrack;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_51 {
    List<List<String>> res=new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board= new char[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        dfs(board,0);
        return res;
    }
    private void dfs(char[][] board,int row){
        if (row==board.length){
            List<String> list=new LinkedList<>();
            for (int i=0;i<board.length;i++){
                char[] ch =board[i];
                list.add(new String(ch));
            }
            res.add(list);
            return;
        }
        for (int col=0;col<board.length;col++){
            if (!isValid(board,row,col)){
                continue;
            }
            board[row][col]='Q';
            dfs(board,row+1);
            board[row][col]='.';
        }
    }
    private boolean isValid(char[][] board,int row,int col){
        for (int i=0;i<board.length;i++){
            if (board[i][col]=='Q'){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        for (int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Leetcode_51().solveNQueens(4);
    }
}
