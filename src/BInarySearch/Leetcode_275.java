package BInarySearch;

public class Leetcode_275 {
    public static void main(String[] args) {
        int[] nums = {11,12};
        System.out.println(hIndex(nums));
    }
    public static int hIndex(int[] citations) {
        int n=citations.length;
        if (n==0)
            return 0;
        if (n==1&&citations[0]!=0) {
            return 1;
        }
        if (n==1&&citations[0]==0) {
            return 0;
        }
        if (citations[0]==citations[n-1]){
            if (citations[0]>=n)
                return n;
            else
                return citations[0];
        }
        for (int i=n;i>0;i--){
            int left =0;
            int right = n-1;
            //找出大于等于i的最小索引
            while (left<right){
                int mid = left+((right-left)>>1);
                if (citations[mid]<i){
                    left=mid+1;
                }else if (citations[mid]==i){
                    right=mid;
                }else {
                    right=mid-1;
                }
            }
            if (citations[left]>=i) {
                int index = left;
                if (n-index>=i) {
                    return i;
                }
            }
        }
        return 0;
    }
}
