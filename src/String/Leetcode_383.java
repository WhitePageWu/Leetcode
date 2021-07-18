package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Leetcode_383
 * @description: TODO 赎金信
 * @author: wuyurong
 * @date: 2021/7/17
 **/
public class Leetcode_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++){
            Character c = magazine.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < ransomNote.length(); i++){
            Character c = ransomNote.charAt(i);
            if (map.containsKey(c)){
                int val = map.get(c)-1;
                if (val == 0){
                    map.remove(c);
                }else {
                    map.put(c,val);
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
