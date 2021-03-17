package QueueAndStack;

import java.util.Stack;

public class Leetcode_232 {

}

class MyQueues {
    Stack<Integer> stack1,stack2;
    /** Initialize your data structure here. */
    public MyQueues() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()){
            stack1Tostack2();
        }
    }
    public  void stack1Tostack2(){
        while (!stack1.isEmpty()){
            int x = stack1.pop();
            stack2.push(x);
        }
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        if (!stack1.isEmpty()){
            stack1Tostack2();
            return stack2.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()){
            return stack2.peek();
        }
        if (!stack1.isEmpty()){
            stack1Tostack2();
            return stack2.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}