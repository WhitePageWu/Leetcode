package BinaryTree;

import java.util.*;

//二叉树中的众树
public class Leetcode_501 {

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
                map.put(key,map.getOrDefault(key,0)+1);
                node=node.right;
            }
        }
        return null;
    }
    public static String getMapMaxValueKey(Map<String, Double> map) {
        List<Map.Entry<String,Double>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue().intValue() - o2.getValue().intValue()));
        String key = "";
        key = list.get(list.size() - 1).getKey();
        return key;
    }

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap();
        map.put("1", 8.);
        map.put("2", 12.);
        map.put("3", 53.);
        map.put("4", 53.);
        map.put("5", 11.);
        map.put("6", 3.);
        map.put("7", 3.);
        map.put("8", 1.);
        System.out.println(getMapMaxValueKey(map));
    }
}
