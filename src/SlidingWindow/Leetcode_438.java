package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode_438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for (int i=0; i<p.length();i++){
            Character c = p.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0, right=0;
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
            while (right-left>=p.length()){
                if (valid==need.size()){
                    list.add(left);
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
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}
