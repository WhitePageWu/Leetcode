package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: Leetcode_142
 * @description: TODO LRU缓存机制
 * @author: wuyurong
 * @date: 2021/5/25
 **/
public class Leetcode_146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5,5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
    }
}

class LRUCache {
    //双向链表
    class Node{
        public int key,val;
        public Node next, pre;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        public Node(){}
    }
    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node==null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null){
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size>capacity){
                Node deNode = removeTail();
                cache.remove(deNode.key);
                --size;
            }
        }else {
            node.val=value;
            moveToHead(node);
        }
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    public void addToHead(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    public void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre=node.pre;
    }
    public Node removeTail(){
        Node res = tail.pre;
        tail.pre=res.pre;
        res.pre.next=tail;
        return res;
    }

}
