package String;

import java.util.HashSet;
import java.util.Set;

/**
 * @className: Leetcode_5161
 * @description: TODO 类描述
 * @author: wuyurong
 * @date: 2021/7/18
 **/
public class Leetcode_5161 {
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        if (brokenLetters.length() == 0){
            return words.length;
        }
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()){
            set.add(c);
        }
        int num = 0;
        for (int i = 0; i < words.length; i ++){
            boolean flag = false;//不包含
            for (char c : words[i].toCharArray()){
                if (set.contains(c)){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String a = "leet code";
        String b = "e";
        System.out.println(canBeTypedWords(a,b));
    }
}
