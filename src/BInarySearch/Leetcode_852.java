package BInarySearch;

public class Leetcode_852 {
    public static int peakIndexInMountainArray(int[] arr) {
        int n =arr.length;
        int left = 0,right = n-1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (arr[mid]<arr[mid+1]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int arr[] ={0,10,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
