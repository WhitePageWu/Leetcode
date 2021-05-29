package SlidingWindow;

import java.util.HashMap;

public class Leetcode_76 {
    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for (int i =0;i<t.length();i++){
            Character c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;
        while (right<s.length()){
            Character c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (valid==need.size()){
                if (right-left<len){
                    start=left;
                    len = right-left;
                }
                Character d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow1("ADOBECODEBANC","ABC"));
    }
    public static String minWindow1(String s, String t) {
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for(int i =0;i<t.length();i++){
            Character c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int start =0;
        int len = Integer.MAX_VALUE;
        int valid = 0;//符合要求的个数
        while (right<s.length()){
            Character c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (valid==need.size()){
                if (right-left<len){
                    start=left;
                    len=right-left;
                }
                Character d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
