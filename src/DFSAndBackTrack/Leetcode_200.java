package DFSAndBackTrack;

/**
 * @className: Leetcode_200
 * @description: TODO 岛屿数量
 * @author: wuyurong
 * @date: 2021/5/30
 **/
public class Leetcode_200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0||i>=m||j<0||j>=n){
            return;
        }
        if (grid[i][j]=='1'){
            grid[i][j] = '0';
        }else {
            return;
        }
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
