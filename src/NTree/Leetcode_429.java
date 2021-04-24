package NTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i=0;i<size;i++){
                Node node=queue.poll();
                subList.add(node.val);
                List<Node> children = node.children;
                for (Node x:children){
                    queue.add(x);
                }
            }
            list.add(subList);
        }
        return list;
    }
}
