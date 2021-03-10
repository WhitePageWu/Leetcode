package BinaryTree;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
public class Leetcode297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return resialize(root,"");
    }

    public String resialize(TreeNode root,String str){
        if (root==null){
            return str+"None,";
        }else {
            str+=root.val+",";
            resialize(root.left,str);
            resialize(root.right,str);
        }
        return str;
    }
    // Decodes your encoded data to tree.
    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

}
