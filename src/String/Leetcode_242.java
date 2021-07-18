package String;

import java.util.Arrays;

/**
 * @className: Leetcode_242
 * @description: TODO 字母异位词
 * @author: wuyurong
 * @date: 2021/7/17
 **/
public class Leetcode_242 {
    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return new String(ch1).equals(new String(ch2));
    }
}
