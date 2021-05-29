package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @className: Leetcode_120
 * @description: TODO 动态规划——三角形最小l路径和
 * @author: wuyurong
 * @date: 2021/5/25
 **/
public class Leetcode_120 {
    /**
     *@描述  递归方法
     *@参数 [java.util.List<java.util.List<java.lang.Integer>>]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     *@修改人和其它信息
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();//三角形的高度
        if (len == 0){
            return 0;
        }
        int sum = triangle.get(0).get(0);//最顶层元素
        return sum+ traverse(0,0,triangle);
    }
    public static int traverse(int i ,int j,List<List<Integer>> triangle){
        if (i>=triangle.size()-1){
            return 0;
        }
        int leftSum = triangle.get(i+1).get(j) + traverse(i+1,j,triangle);
        int rightSum = triangle.get(i+1).get(j+1) + traverse(i+1,j+1,triangle);
        return Math.min(leftSum,rightSum);
    }
    /**
     *@描述 递归带hash剪枝操作
     *@参数 [java.util.List<java.util.List<java.lang.Integer>>]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     */
    static HashMap<String,Integer> map = new HashMap<>();
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int len = triangle.size();//三角形的高度
        if (len == 0){
            return 0;
        }
        int sum = triangle.get(0).get(0);//最顶层元素
        return sum+ traverse(0,0,triangle);
    }

    public static int traverse1(int i ,int j,List<List<Integer>> triangle){
        String key = i + "" + j;
        if (map.get(key) != null) {
            return map.get(key);
        }
        if (i>=triangle.size()-1){
            return 0;
        }
        int leftSum = triangle.get(i+1).get(j) + traverse(i+1,j,triangle);
        int rightSum = triangle.get(i+1).get(j+1) + traverse(i+1,j+1,triangle);
        int result =  Math.min(leftSum,rightSum);
        map.put(key,result);
        return result;
    }

    /**
     *@描述  动态规划方法
     *@参数 [java.util.List<java.util.List<java.lang.Integer>>]
     *@返回值 int
     *@创建人 wuyurong
     *@创建时间 2021/5/25
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len+1][len+1];
        for (int i = len - 1; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i+1][j]+triangle.get(i).get(j),dp[i+1][j+1]+triangle.get(i).get(j));
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);list.add(list2);list.add(list3);list.add(list4);
        System.out.println(minimumTotal2(list));
    }
}
