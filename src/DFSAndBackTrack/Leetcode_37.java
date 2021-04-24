package DFSAndBackTrack;

import java.util.HashMap;

public class Leetcode_37 {
    public void solveSudoku(char[][] board) {

        dfs(board,0,0);
    }
    private boolean dfs(char[][] board,int row,int col){
        if (col==9){
            return dfs(board,row+1,0);
        }
        if (row==9){
            return true;
        }
        for (int i=row;i<9;i++){
            for (int j=col;j<9;j++){
                if (board[i][j]=='.'){
                    return dfs(board,row,col+1);
                }
                for (char ch='1';ch<='9';ch++){
                    if (!isValid(board,i,j,ch)){
                        continue;
                    }
                    board[i][j]=ch;
                    if (dfs(board,row,col+1)){
                        return true;
                    }
                    board[i][j]='.';
                }
                return false;
            }
        }
        return false;
    }
    private boolean isValid(char[][] board,int row,int col,char n){
        for (int i=0;i<9;i++){
            if (board[row][i]==n){
                return false;
            }
            if (board[i][col]==n){
                return false;
            }
            if (board[(row/3)*3 + i/3][(col/3)*3 + i%3] == n){
                return false;
            }
        }
        return true;
    }
}
