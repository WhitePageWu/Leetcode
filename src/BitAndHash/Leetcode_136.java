package BitAndHash;

public class Leetcode_136 {
    public static void main(String[] args) {
        System.out.println();
    }
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int x :nums){
            single^=x;
        }
        return single;
    }
}
