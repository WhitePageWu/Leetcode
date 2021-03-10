package QueueAndStack;

public class MyLoopQueue {
    private int[] queue;
    private int start;
    private int end;
    private int size;
    public MyLoopQueue(int size){
        queue=new int[size];
        start=-1;
        end=-1;
        this.size=size;
    }
    public boolean enLoopQueue(int x){
        if (start==-1&&end==-1){
            start=0;
            end=0;
            queue[end]=x;
        }else {
            end=(end+1)%size;
            queue[end]=x;
        }
        return true;
    }
    public boolean deLoopQueue(){
        if (start==end){//最后一个元素
            queue[start]=0;
            start=-1;
            end=-1;
        }else {
            queue[start]=0;
            start=(start+1)%size;
        }
        return true;
    }
}
