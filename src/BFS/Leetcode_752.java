package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode_752 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String s:deadends){
            dead.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step=0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                String s = queue.poll();
                if (dead.contains(s)){
                    continue;
                }
                if (s.equals(target)){
                    return step;
                }
                for (int j=0;j<4;j++){
                    String plus = plusOne(s,j);
                    if (!visited.contains(plus)){
                        queue.add(plus);
                        visited.add(plus);
                    }
                    String minus = minusOne(s,j);
                    if (!visited.contains(minus)){
                        queue.add(minus);
                        visited.add(minus);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public String plusOne(String s,int i){
        char[] ch = s.toCharArray();
        if (ch[i]=='9'){
            ch[i]='0';
        }else {
            ch[i]+=1;
        }
        return new String(ch);
    }
    public String minusOne(String s,int i){
        char[] ch = s.toCharArray();
        if (ch[i]=='0'){
            ch[i]='9';
        }else {
            ch[i]-=1;
        }
        return new String(ch);
    }
    //双向搜索
    public int openLock1(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String s:deadends){
            dead.add(s);
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        int step=1;
        while (!q1.isEmpty()&&!q2.isEmpty()){
            Set<String> temp = new HashSet<>();
            int size = q1.size();
            for (String cur:q1){
                if (visited.contains(cur)){
                    continue;
                }
                if (cur.equals(target)){
                    return step;
                }
                for (int i=0;i<4;i++){
                    String up = plusOne(cur,i);
                    if (!visited.contains(up)){
                        temp.add(up);
                    }
                    String down = minusOne(cur,i);
                    if (!visited.contains(cur)){
                        temp.add(down);
                    }
                }
            }
            step++;
            q1=q2;
            q2=visited;
        }
        return -1;
    }

}
