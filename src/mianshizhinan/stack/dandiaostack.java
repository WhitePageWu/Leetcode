package mianshizhinan.stack;

import java.util.Stack;

public class dandiaostack {
    public int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty()?-1:stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty()?-1:stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

}
