package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @className: Leetcode_387
 * @description: TODO 字符串中的第一个唯一的字符
 * @author: wuyurong
 * @date: 2021/7/17
 **/
public class Leetcode_387 {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Set<Character> set = map.keySet();
        Iterator<Character> it = set.iterator();
        int index = -1;
        while (it.hasNext()){
            Character key = it.next();
            if (map.get(key)==1){
                if (index == -1){
                    index = s.indexOf(key);
                }else {
                    index = Math.min(index, s.indexOf(key));
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "aabb";
//        System.out.println(s.indexOf("l"));
        System.out.println(firstUniqChar(s));
    }
}
