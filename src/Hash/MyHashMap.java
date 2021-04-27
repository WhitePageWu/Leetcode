package Hash;

import java.util.LinkedList;
import java.util.ListIterator;

class Nodes{
    int key;
    int val;
    public Nodes(int key,int val){
        this.key=key;
        this.val=val;
    }
    public int getKey(){
        return key;
    }
    public int getVal(){
        return val;
    }
    public void setVal(int val){
        this.val=val;
    }
}
public class MyHashMap {
    private static final int BASE = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Nodes>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%BASE;
        LinkedList list = data[index];
        ListIterator<Nodes> it = list.listIterator();
        while (it.hasNext()){
            Nodes nodes=it.next();
            if (nodes.getKey()==key){
                nodes.setVal(value);
                return;
            }
        }
        list.add(new Nodes(key,value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%BASE;
        LinkedList list = data[index];
        ListIterator<Nodes> it = list.listIterator();
        while (it.hasNext()){
            Nodes nodes = it.next();
            if (nodes.getKey()==key){
                return nodes.val;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%BASE;
        LinkedList list = data[index];
        ListIterator<Nodes> it = list.listIterator();
        while (it.hasNext()){
            if (it.next().getKey()==key){
                it.remove();
            }
        }
    }
}
