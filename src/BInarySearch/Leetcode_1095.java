package BInarySearch;

class MountainArray {
    private int[] arr={0,5,3,1};
     public int get(int index) {
         return arr[index];
     }
     public int length() {
         return arr.length;
     }
}
public class Leetcode_1095 {
    public static void main(String[] args) {
        System.out.println(findInMountainArray(1,new MountainArray()));
    }
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int n =mountainArr.length();
        int left = 0,right = n-1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (mountainArr.get(mid)<mountainArr.get(mid+1)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        int peakIndex = left;
        return getMinTargetIndex(target,mountainArr,peakIndex);
    }
    public static int getMinTargetIndex(int target,MountainArray mountainArray,int peakIndex){
        int min = -1;
        if (mountainArray.get(peakIndex)==target){
            min=peakIndex;
        }
        int left = 0,right = peakIndex-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            if (mountainArray.get(mid)==target){
                min = mid;
                return min;
            }else if (mountainArray.get(mid)<target){
                left=mid+1;
            }else if (mountainArray.get(mid)>target){
                right =mid-1;
            }
        }
        left = peakIndex+1;
        right = mountainArray.length()-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            if (mountainArray.get(mid)==target){
                min = mid;
                return min;
            }else if (mountainArray.get(mid)>target){
                left=mid+1;
            }else if (mountainArray.get(mid)<target){
                right =mid-1;
            }
        }
        return min;
    }
}
