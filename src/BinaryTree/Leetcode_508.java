package BinaryTree;

import java.util.*;

public class Leetcode_508 {
    int maxnum=1;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        subTreeSum(root,map);
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
    public int subTreeSum(TreeNode root,Map<Integer,Integer> map){
        if (root==null){
            return 0;
        }
        int leftsum = subTreeSum(root.left,map);
        int rightsum=subTreeSum(root.right,map);
        int sum = root.val+leftsum+rightsum;
        if (map.containsKey(sum)){
            int val = map.get(sum)+1;
            map.put(sum,val);
            if (val>maxnum){
                maxnum=val;
            }
        }else {
            map.put(sum,1);
        }
        return sum;
    }
}
