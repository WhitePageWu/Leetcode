package SlidingWindow;

import java.util.HashMap;

public class Leetcode_3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 1;
        while (right<s.length()){
            Character c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            while (window.get(c)>1){
                Character d = s.charAt(left);
                left++;
                window.put(d,window.getOrDefault(d,0)-1);
            }
            max = max>(right-left)?max:(right-left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
