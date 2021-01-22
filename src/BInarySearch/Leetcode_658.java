package BInarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode_658 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,-1));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n =arr.length;
        if (k>=n){
            for (int temp:arr){
                list.add(temp);
            }
            return list;
        }
        int left =0;
        int right = n-1;
        int index=-1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (arr[mid]==x){
                index=mid;
                break;
            }else if (arr[mid]>x){
                right=mid-1;
            }else if (arr[mid]<x){
                left=mid+1;
            }
        }
        if (x==-1){
            if (right<0)
                index=left;
            else if (left==n){
                index=right;
            }else
                index=Math.abs(arr[right]-x)<Math.abs(arr[left]-x)?right:left;//index为最接近x的数的索引
        }
        int i=index,j=index+1;
        int count = 0;
        while (count<k&&(i>=0||j<n)){
            if (i<0){
                list.add(arr[j]);
                j++;
            }
            if (j==n){
                list.add(arr[i]);
                i--;
            }
            if (Math.abs(arr[i]-x)==Math.abs(arr[j]-x)){
                list.add(arr[i]);
                i--;
            } else if (Math.abs(arr[i]-x)<Math.abs(arr[j]-x)){
                list.add(arr[i]);
                i--;
            }else{
                list.add(arr[j]);
                j++;
            }
            count++;
        }
        Comparator c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                if ((int) o1 < (int) o2)
                    return 1;
                    //注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
                    //      else return 0; //无效
                else return -1;
            }
        };
        Collections.sort(list);
        return list;
    }
}
