package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_117 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;
        connect(node1);
    }
    public static Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root==null){
            return null;
        }
        queue.add(root);
        connectTwoNode(queue);
        return root;
    }
    public static void connectTwoNode(Queue<Node> queue){
        Node first = null;
        if (!queue.isEmpty()){
            first=queue.remove();
        }else {
            return;
        }
        Node last = first;
        int size = queue.size();
        if (first.left!=null){
            queue.add(first.left);
        }
        if (first.right!=null){
            queue.add(first.right);
        }
        int i =0;
        while (i<size){
            Node node = queue.remove();
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
            last.next=node;
            last=last.next;
            i++;
        }
        connectTwoNode(queue);
    }
}
