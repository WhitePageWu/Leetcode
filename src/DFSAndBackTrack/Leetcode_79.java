package DFSAndBackTrack;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_79 {
    int[] x={-1,0,0,1};
    int[] y={0,1,-1,0};
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        Set<String> visited = new HashSet<>();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (first==board[i][j]&&dfs(board,i,j,word,0,visited)){
                     return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int row,int col,String word,int index,Set<String> visited){
        if (index==word.length()-1&&board[row][col]==word.charAt(index)){
            return true;
        }
        if (board[row][col]!=word.charAt(index)){
            return false;
        }
        visited.add(row+","+col);
        for (int i=0;i<4;i++){
            row = row+x[i];
            col = col+y[i];
            if (row>=0&&row<board.length&&col>=0&&col<board[row].length&&!visited.contains(row+","+col)){
                if (dfs(board,row,col,word,index+1,visited)){
                    return true;
                }
            }
            row=row-x[i];
            col=col-y[i];
        }
        visited.remove(row+","+col);
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        new Leetcode_79().exist(board,"AAB");
    }
}
