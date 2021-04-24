package BFS;

import java.util.*;

//01矩阵
public class Leetcode_542 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] ret = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    ret[i][j]=0;
                }else {
                    int distance = distance(matrix,i,j);
                    ret[i][j]=distance;
                }
            }
        }
        return ret;
    }
    //基于广度优先
    public int distance(int[][] matrix,int i,int j){
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(i+","+j);
        String s = i+","+j;
        q.add(s);
        int step =0;
        while (!q.isEmpty()){
            int size=q.size();
            for (int k=0;k<size;k++){
                String[] strs = q.poll().split(",");
                int x=Integer.valueOf(strs[0]);
                int y=Integer.valueOf(strs[1]);
                if (matrix[x][y]==0){
                    return step;
                }
                if ((x-1)!=-1&&!visited.contains((x-1)+","+y)){
                    String next = (x-1)+","+y;
                    q.offer(next);
                    visited.add(next);
                }
                if ((x+1)!=matrix.length&&!visited.contains((x+1)+","+y)){
                    String next = (x+1)+","+y;
                    q.offer(next);
                    visited.add(next);
                }
                if ((y-1)!=-1&&!visited.contains(x+","+(y-1))){
                    String next = x+","+(y-1);
                    q.offer(next);
                    visited.add(next);
                }
                if ((y+1)!=matrix[x].length&&!visited.contains(x+","+(y+1))){
                    String next = x+","+(y+1);
                    q.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix={{0,0,0},{0,1,0},{1,1,1}};
        new Leetcode_542().updateMatrix(matrix);
    }
}
