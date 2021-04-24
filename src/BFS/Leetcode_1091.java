package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode_1091 {
    int[] dx={0,0,1,-1,1,1,-1,-1};
    int[] dy={1,-1,0,0,1,-1,-1,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        visited.add(0+","+0);
        int step =1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int[] location = queue.poll();
                int x = location[0];
                int y = location[1];
                if (x==len-1&&y==len-1){
                    return step;
                }
                for (int j=0;j<8;j++){
                    int nextLocationX = x+dx[j];
                    int nextLocationY = y+dy[j];
                    if (nextLocationX>=0&&nextLocationX<grid.length&&nextLocationY>=0&&nextLocationY<grid.length&&grid[nextLocationX][nextLocationY]!=1&&!visited.contains(nextLocationX+","+nextLocationY)){
                        queue.add(new int[]{nextLocationX,nextLocationY});
                        visited.add(nextLocationX+","+nextLocationY);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        new Leetcode_1091().shortestPathBinaryMatrix(grid);
    }
}
