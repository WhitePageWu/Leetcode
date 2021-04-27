package Array;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tem = new ArrayList<>();
        tem.add(1);
        ret.add(tem);
        for (int i = 1;i<numRows;i++){
            int len = ret.size();
            List<Integer> tail = ret.get(len-1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j=1;j<tail.size();j++){
                temp.add(tail.get(j)+tail.get(j-1));
            }
            temp.add(1);
            ret.add(temp);
        }
        return ret;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
