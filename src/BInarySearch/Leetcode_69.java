package BInarySearch;

public class Leetcode_69 {
    public static void main(String[] args) {
        mySqrt(2147395599);
    }
    public static int mySqrt(int x) {
        int left =1;
        int right = x/2;
        if (x==0)
            return 0;
        if (x==1||x==2)
            return 1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (x/mid==mid){
                return mid;
            }else if (x/mid>mid){
                left=mid+1;
            }else if (x/mid<mid){
                right=mid-1;
            }
        }
        return left-1;
    }
}
