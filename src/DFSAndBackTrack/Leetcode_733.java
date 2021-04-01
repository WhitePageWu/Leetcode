package BackTrack;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_733 {
    int old;
    Set<String> visited = new HashSet<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        old=image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc ,int newColor){
        if (image[sr][sc]==old){
            visited.add(sr+","+sc);
            image[sr][sc]=newColor;
        }else {
            return;
        }
        if ((sr-1)!=-1&&!visited.contains((sr-1)+","+sc)){
            dfs(image,sr-1,sc,newColor);
        }
        if ((sr+1)!=image.length&&!visited.contains((sr+1)+","+sc)){
            dfs(image,sr+1,sc,newColor);
        }
        if ((sc-1)!=-1&&!visited.contains(sr+","+(sc-1))){
            dfs(image,sr,sc-1,newColor);
        }
        if ((sc+1)!=image[sr].length&&!visited.contains(sr+","+(sc+1))){
            dfs(image,sr,sc+1,newColor);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,1}};
        new Leetcode_733().floodFill(arr,1,1,1);
    }
}
