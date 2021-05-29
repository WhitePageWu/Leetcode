package DynamicProgramming;

import BinaryTree.TreeNode;

import java.util.HashMap;

/**
 * @className: Leetcode_337
 * @description: TODO 打家劫舍三：树形动归
 * @author: wuyurong
 * @date: 2021/5/27
 **/
public class Leetcode_337 {
    /**
     *@描述 递归法：比较爷爷节点+四个孙子节点的值和两个儿子节点值的大小
     *@参数 [BinaryTree.TreeNode]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/27
     */
    public int rob1(TreeNode root) {
        if (root==null){
            return 0;
        }
        int money = root.val;
        if (root.left!=null){
            money= money+ rob1(root.left.left)+rob1(root.left.right);
        }
        if (root.right!=null){
            money = money+rob1(root.right.left)+rob1(root.right.right);
        }
        return Math.max(money,rob1(root.left)+rob1(root.right));
    }
    /**
     *@描述 方法二：带记忆功能的递归
     *@参数 [BinaryTree.TreeNode]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/27
     */
    HashMap<TreeNode,Integer> map = new HashMap<>();
    public int rob2(TreeNode root){
        if (root==null){
            return 0;
        }
        if (map.containsKey(root)){
            return map.get(root);
        }
        int money = root.val;
        if (root.left!=null){
            money= money+ rob2(root.left.left)+rob2(root.left.right);
        }
        if (root.right!=null){
            money = money+rob2(root.right.left)+rob2(root.right.right);
        }
        int max = Math.max(money,rob2(root.left)+rob2(root.right));
        map.put(root,max);
        return max;
    }
    /**
     *@描述   动态规划方法
     * 1。当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 2。当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     *@参数 [BinaryTree.TreeNode]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/27
     */
    public int rob3(TreeNode root){
        int[] res = robInternel(root);
        return Math.max(res[0],res[1]);
    }
    public int[] robInternel(TreeNode root){
        if (root == null){
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = robInternel(root.left);
        int[] right = robInternel(root.right);
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = root.val + left[0]+right[0];
        return res;
    }
}
