package Design;

import java.util.Stack;

/**
 * @className: Leetcode_232
 * @description: TODO 用栈实现队列
 * @author: wuyurong
 * @date: 2021/5/30
 **/
public class Leetcode_232 {
}

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    public void moveStack1ToStack2(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        if (!stack1.isEmpty()){
            moveStack1ToStack2();
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
            moveStack1ToStack2();
            return stack2.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
