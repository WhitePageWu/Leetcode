package QueueAndStack;

import java.util.Stack;

public class Leetcode_150 {
    Stack<Integer> stack = new Stack<Integer>();
    public int evalRPN(String[] tokens) {
        if (tokens.length==0) {
            return 0;
        }
        for (int i=0;i<tokens.length;i++){
            if (!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("*")&&!tokens[i].equals("/")){
                stack.push(Integer.valueOf(tokens[i]));
            }else{
                int b = stack.pop();
                int a = stack.pop();
                int res = 0;
                if (tokens[i].equals("+")){
                    res = a+b;
                }else if (tokens[i].equals("-")){
                    res = a-b;
                }else if (tokens[i].equals("*")){
                    res = a*b;
                }else if (tokens[i].equals("/")){
                    res = a/b;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_150().evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
