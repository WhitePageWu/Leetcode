package QueueAndStack;

import java.util.ArrayList;
import java.util.List;

//简单队列
public class MyQueue {
    private List<Integer> data;
    private int start;
    public MyQueue(){
        data = new ArrayList<>();
        start=0;
    }
    public boolean enQueue(int x){
        data.add(x);
        return true;
    }
    public boolean deQueue(){
        if (isEmpty()){
            return false;
        }
        data.remove(start);
        return true;
    }
    public int front(){
        return data.get(start);
    }
    public boolean isEmpty(){
        return data.size()==0?true:false;
    }
    public int size(){
        return data.size();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        System.out.println(queue.size());
        System.out.println(queue.front());
        queue.deQueue();
        System.out.println(queue.size());
        System.out.println(queue.front());
    }
}
