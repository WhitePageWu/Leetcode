package QueueAndStack;

import java.util.*;

public class Leetcode_739 {
    Stack<Integer> stack = new Stack<>();
    public int[] dailyTemperatures(int[] T) {
        if (T.length==0){
            return new int[0];
        }
        int[] ret = new int[T.length];
        for (int i=0;i<T.length;i++){
            if (!stack.isEmpty()){
                while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                    int n = stack.pop();
                    ret[n]=i-n;
                }
                stack.push(i);
            }else {
                stack.push(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new Leetcode_739().dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
    }
}
