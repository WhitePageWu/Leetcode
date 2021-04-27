package Array;

//两数之和
public class Leetcode_167 {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while (i<j){
            int lnum = numbers[i];
            int rnum = numbers[j];
            if (lnum+rnum==target){
                break;
            }else if (lnum+rnum<target){
                i++;
            }else if (lnum+rnum>target){
                j--;
            }
        }
        return new int[]{i+1,j+1};
    }

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }
}
