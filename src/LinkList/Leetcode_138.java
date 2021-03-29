package LinkList;

import sun.jvm.hotspot.oops.NarrowOopField;

import java.util.ArrayList;
import java.util.List;

//复制带随机指针的链表
public class Leetcode_138 {
    static List<Node> list = new ArrayList<>();
    static List<Node> newList = new ArrayList<>();
    public static Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node newHead = new Node(-1);
        Node newCur = newHead;
        Node cur = head;
        //复制除随机指针外的节点信息
        while (cur!=null){
            list.add(cur);
            Node node = new Node(cur.val);
            newList.add(node);
            newCur.next=node;
            newCur=newCur.next;
            cur=cur.next;
        }
        cur=head;
        newCur=newHead.next;
        while (cur!=null){
            Node node = cur.random;
            if (node!=null){
                int i = list.indexOf(node);
                Node newNode = newList.get(i);
                newCur.random=newNode;
            }
            cur=cur.next;
            newCur=newCur.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next=node2;
        node2.next=node3;
        node2.random=node1;
        node3.next=node4;
        node3.random=node5;
        node4.next=node5;
        node4.random=node3;
        node5.random=node1;
        copyRandomList(node1);
    }
}
