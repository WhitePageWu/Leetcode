package SlidingWindow;

import java.util.HashMap;

public class Leetcode_395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0;i < s.length(); i++){
            Character c = s .charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (Character c : map.keySet()){
            if (map.get(c) < k){
                int res = 0;
                for (String sub : s.split(String.valueOf(c))){
                    res = Math.max(res, longestSubstring(sub, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
