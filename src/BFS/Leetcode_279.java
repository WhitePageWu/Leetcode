package BFS;

import Array.Leetcode_200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_279 {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int level =0;
        queue.add(n);
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i=0;i<size;i++){
                int cur = queue.poll();
                for (int j=1;j*j<=cur;j++){
                    int next =cur-j*j;
                    if (next==0){
                        return level;
                    }
                    if (!set.contains(next)){
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        new Leetcode_279().numSquares1(12);
    }
    public int numSquares1(int n) {
        return numSquaresHelper(n, new HashMap<Integer, Integer>());
    }

    private int numSquaresHelper(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresHelper(n - i * i, map) + 1);
        }
        map.put(n, count);
        return count;
    }

}
