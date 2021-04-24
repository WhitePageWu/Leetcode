package DFSAndBackTrack;

public class Leetcode_130 {
    public void solve(char[][] board) {
        for (int i=0;i<board.length;i++){
            if (i==0||i==board.length-1){
                for (int j=0;j<board[i].length;j++){
                    dfs(board,i,j);
                }
            }else{
                dfs(board,i,0);
                dfs(board,i,board[i].length-1);
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
                if (board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        if (i<0||i>=board.length||j<0||j>=board[i].length||board[i][j]!='O'){
            return;
        }
        board[i][j]='#';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }

    public static void main(String[] args) {
        char[][] ch = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        new Leetcode_130().solve(ch);
    }
}
