package NTree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_559 {
    int max=0;
    public int maxDepth(Node root) {
        if (root==null){
            return 0;
        }
        List<Node> childer = root.children;
        if (childer==null){
            return 1;
        }
        for (Node x:childer){
            int h = maxDepth(x)+1;
            if (h>max){
                max=h;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        List<Node> childrn = new ArrayList<>();
        childrn.add(node2);
        childrn.add(node3);
        childrn.add(node4);
        node1.children=childrn;
        List<Node> child = new ArrayList<>();
        child.add(node5);
        node2.children=child;
        new Leetcode_559().maxDepth(node1);
    }
}
