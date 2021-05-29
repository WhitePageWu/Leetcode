package SlidingWindow;

import java.util.HashMap;

public class Leetcode_567 {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for (int i =0;i<s1.length();i++){
            Character c = s1.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int start=0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        while (right<s2.length()){
            Character c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            if (right-left>=s1.length()){
                if (valid==need.size()){
                    return true;
                }
                Character d = s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "ccccbbbbaaaa"));
    }
}
