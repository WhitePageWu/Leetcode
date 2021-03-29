package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//弹出最小元素的栈
public class Leetcode_ms_39 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int a= minStack.min();
        minStack.pop();
        int c= minStack.top();
        int d=minStack.min();
    }
}

class MinStack {
    Stack<Integer> stackData;
    Stack<Integer> stackMin;
    /** initialize your data structure here. */
    public MinStack() {
        stackData=new Stack<>();
        stackMin =new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.size()==0||stackMin.peek()>=x){
            stackMin.push(x);
        }
    }

    public void pop() {
        int i = stackData.pop();
        if (i==stackMin.peek()){
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
