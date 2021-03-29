package QueueAndStack;

import java.util.Stack;

public class Leetcode_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i=0;i<ch.length;i++){
            if (stack.isEmpty()){
                stack.push(ch[i]);
            }else {
                char c = stack.peek();
                if ((c=='('&&ch[i]==')')||(c=='['&&ch[i]==']')||(c=='{'&&ch[i]=='}')){
                    stack.pop();
                }else {
                    stack.push(ch[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_20().isValid("({[)"));;
    }
}
