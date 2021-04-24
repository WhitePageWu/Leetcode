package Graph;

import java.util.*;

public class Leetcode_133 {
    //BFS广度优先遍历
    public Node cloneGraph(Node node) {
        if (node==null){
            return null;
        }
        HashMap<Node,Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            for (Node neighbor: cur.neighbors){
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    //DFS
    public Node cloneGraph1(Node node) {
        return clone(node,new HashMap<Node,Node>());
    }
    public Node clone(Node node,HashMap<Node,Node> visited){
        if (node==null){
            return null;
        }
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node newNode = new Node(node.val,new ArrayList<>());
        visited.put(node,newNode);
        List<Node> list = node.neighbors;
        for (Node cur:list){
            newNode.neighbors.add(clone(cur,visited));
        }
        return newNode;

    }


    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        new Leetcode_133().cloneGraph(node1);
    }
}
