package BinaryTree;

import java.util.*;

//二叉树中的众树
public class Leetcode_501 {
    int maxnum=0;
    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        while (root!=null||(!stack.isEmpty())){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else {
                TreeNode node = stack.pop();
                int key = node.val;
                if (map.containsKey(key)){
                    int val = map.get(key)+1;
                    map.put(key,val);
                    if (val>maxnum){
                        maxnum=val;
                    }
                }else {
                    map.put(key,1);
                }
                root=node.right;
            }
        }
        List<Integer> list = new ArrayList<>();
        Set<Integer> keys = map.keySet();
        for (int key :keys){
            if (map.get(key)==maxnum){
                list.add(key);
            }
        }
        int[] ret = new int[list.size()];
        for (int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.right=node2;
        node2.left=node3;
        new Leetcode_501().findMode(node1);
    }
}
