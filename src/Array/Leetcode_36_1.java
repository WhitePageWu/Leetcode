package Array;

import java.util.HashMap;

/**
 * @className: Leetcode_36_1
 * @description: TODO 有效的数独二刷
 * @author: wuyurong
 * @date: 2021/7/16
 **/
public class Leetcode_36_1 {
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer>[] rows = new HashMap[9];
        HashMap<Character, Integer>[] cols = new HashMap[9];
        HashMap<Character, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++){
            rows[i] = new HashMap<Character, Integer>();
            cols[i] = new HashMap<Character, Integer>();
            boxes[i] = new HashMap<Character, Integer>();
        }
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                Character c = board[i][j];
                if (c != '.'){
                    int box_index = (i / 3) * 3 + j / 3;
                    if (rows[i].getOrDefault(c,0)!=0||cols[j].getOrDefault(c,0)!=0||
                    boxes[box_index].getOrDefault(c,0)!=0){
                        return false;
                    }
                    rows[i].put(c,1);
                    cols[j].put(c,1);
                    boxes[box_index].put(c,1);
                }
            }
        }
        return true;
    }

}


