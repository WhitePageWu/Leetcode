package Daily;

import java.util.Stack;
import java.util.regex.Pattern;

public class Leetcode_224 {
    public static void main(String[] args) {
        String s = "1 + 1";
        calculate(s);
    }
    public static int calculate(String s) {
        int res = 0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i =0;i<s.length();i++){
            char cur = s.charAt(i);
            if (cur!='('&&cur!=')'&&cur!='"'){
              if (isInteger(cur+"")||cur=='-'){
                  int j = i;
                  while (j<s.length()&&isInteger(s.charAt(j)+"")){
                      j++;
                  }
                  int temp = Integer.valueOf(s.substring(i,j));
                  if (stack1.isEmpty()){
                      stack1.push(temp);
                  }else {
                      int a = stack1.pop();
                      char reg = stack2.pop();
                      if (reg=='+'){
                          int re = a+temp;
                          stack1.push(re);
                      }else if (reg=='-'){
                          int re = a-temp;
                          stack1.push(re);
                      }
                  }
                  i=j-1;
              }else {
                  if(cur==' '){
                      continue;
                  }
                  if (stack2.isEmpty()){
                      stack2.push(cur);
                  }
              }
            }
        }
        return stack1.pop();
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
