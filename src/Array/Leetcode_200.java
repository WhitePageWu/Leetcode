package Array;

public class Leetcode_200 {
    public int numIslands(char[][] grid) {
        int nums = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    nums++;
                }
            }
        }
        return nums;
    }
    public void dfs(char[][] grid,int i,int j){
        grid[i][j]='0';
        if ((j+1)!=grid[i].length&&grid[i][j+1]=='1'){
            dfs(grid,i,j+1);
        }
        if ((j-1)!=-1&&grid[i][j-1]=='1'){
            dfs(grid,i,j-1);
        }
        if ((i-1)!=-1&&grid[i-1][j]=='1'){
            dfs(grid,i-1,j);
        }
        if ((i+1)!=grid.length&&grid[i+1][j]=='1'){
            dfs(grid,i+1,j);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        new Leetcode_200().numIslands(grid);
    }
}
