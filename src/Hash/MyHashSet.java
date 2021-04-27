package Hash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyHashSet {
    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        if (contains(key)){
            return;
        }
        int index = key%BASE;
        LinkedList<Integer> list = data[index];
        list.add(key);
    }

    public void remove(int key) {
        if (!contains(key)){
            return;
        }
        int index = key%BASE;
        LinkedList<Integer> list = data[index];
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()){
            if (it.next()==key){
                it.remove();
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%BASE;
        LinkedList<Integer> list = data[index];
        Iterator<Integer> it = list.listIterator();
        while (it.hasNext()){
            if (it.next()==key){
                return true;
            }
        }
        return false;
    }
}
