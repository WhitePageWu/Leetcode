package DFSAndBackTrack;

public class Leetcode_offer_12 {
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        char first = word.charAt(0);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (dfs(board,ch,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,char[] word,int index,int row,int col){
        if(row<0||row>=board.length||col<0||col>=board[row].length||board[row][col]!=word[index]){
            return false;
        }
        if (index==word.length-1){
            return true;
        }
        board[row][col]='\0';
        boolean res = dfs(board,word,index+1,row-1,col)||dfs(board,word,index+1,row+1,col)
                ||dfs(board,word,index+1,row,col-1)||dfs(board,word,index+1,row,col+1);
        board[row][col]=word[index];
        return res;
    }

    public static void main(String[] args) {
        char[][] board ={{'A','B','C','D','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        new Leetcode_offer_12().exist(board,word);
    }
}
