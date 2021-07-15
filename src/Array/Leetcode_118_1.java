package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: Leetcode_118_1
 * @description: TODO 杨辉三角
 * @author: wuyurong
 * @date: 2021/7/15
 **/
public class Leetcode_118_1 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0){
            return list;
        }
        if (numRows >= 1){
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            list.add(subList);
        }
        if (numRows >= 2){
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            subList.add(1);
            list.add(subList);
        }
        for (int i = 2; i < numRows; i++){
            List<Integer> preList = list.get(i-1);
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            for (int j = 0; j < preList.size()-1;j++){
                subList.add(preList.get(j)+preList.get(j+1));
            }
            subList.add(1);
            list.add(subList);
        }
        return list;
    }

    public static void main(String[] args) {
        generate(1);
    }
}
