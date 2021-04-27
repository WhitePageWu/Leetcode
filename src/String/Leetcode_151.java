package String;

import java.util.Stack;

//翻转字符串的顺序
public class Leetcode_151 {
    public static String reverseWords(String s) {
        if (s==null||s.length()==0){
            return "";
        }
        Stack<String> stack = new Stack<>();
        s=s.trim();
        String[] strs = s.split(" ");
        for (String str : strs){
            if (!str.equals("")){
                stack.add(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
            if (stack.size()!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        reverseWords("example   good a");
    }
}
