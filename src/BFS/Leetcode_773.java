package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_773 {
    public int slidingPuzzle(int[][] board) {
        int[][] neighbor={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        String target ="123450";
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        Queue<String> queue=new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int step =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                String cur = queue.poll();
                if (cur.equals(target)){
                    return step;
                }
                int index = cur.indexOf('0');
                int[] next=neighbor[index];
                for (int j=0;j<next.length;j++){
                    String s = swap(cur,next[j],index);
                    if (!visited.contains(s)){
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public String swap(String cur,int swqpIndex,int index){
        char[] ch = cur.toCharArray();
        char temp = ch[swqpIndex];
        ch[swqpIndex]=ch[index];
        ch[index]=temp;
        return new String(ch);
    }

    public static void main(String[] args) {
        int[][] board = {{1,2,3},{5,4,0}};
        System.out.println(new Leetcode_773().slidingPuzzle(board));;
    }
}
