package QueueAndStack;

import java.util.Stack;

/**
 * @className: Leetcode_20_1
 * @description: TODO 有效的括号二刷
 * @author: wuyurong
 * @date: 2021/5/29
 **/
public class Leetcode_20_1 {
    public static boolean isValid(String s) {
        if (s==null||s.length()==0){
            return true;
        }
        if (s.length()%2!=0){
            return false;
        }
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++){
            boolean a = stack.isEmpty();
            if (!stack.isEmpty()&&((ch[i]==')'&&'('==stack.peek())||(ch[i]==']'&&'['==stack.peek())||(ch[i]=='}'&&'{'==stack.peek()))){
                stack.pop();
            }else {
                stack.push(ch[i]);
            }
        }
        return stack.isEmpty()?true:false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));;
    }
}
