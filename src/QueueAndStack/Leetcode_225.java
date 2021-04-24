package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_225 {
    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.push(6);
        stack.top();
    }
}

class MyStack{
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue2.size()==0){
            queue1.offer(x);
        }else {
            queue2.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.size()!=0){
            int size = queue1.size();
            for (int i=0;i<size-1;i++){
                queue2.offer(queue1.remove());
            }
            return queue1.remove();
        }else {
            int size = queue2.size();
            for (int i=0;i<size-1;i++){
                queue1.offer(queue2.remove());
            }
            return queue2.remove();
        }
    }

    /** Get the top element. */
    public int top() {
        if (queue1.size()!=0){
            int size = queue1.size();
            for (int i=0;i<size-1;i++){
                queue2.offer(queue1.remove());
            }
            int x = queue1.remove();
            queue2.offer(x);
            return x;
        }else {
            int size = queue2.size();
            for (int i=0;i<size-1;i++){
                queue1.offer(queue2.remove());
            }
            int x = queue2.remove();
            queue1.offer(x);
            return x;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}