package SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void quickSOrt(int[] arr){
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr,int left,int right){
        if (left<right){
            int j = partition(arr,left,right);
            sort(arr,left,j-1);
            sort(arr,j+1,right);
        }
    }
    public static int partition(int[] arr,int left,int right){
        int i=left;
        int j=right+1;
        int temp = arr[left];
        while (true){
            while (arr[++i]<temp&&i!=right);
            while (arr[--j]>temp&&j!=left);
            if (i>=j){
                break;
            }
            int temp1 = arr[i];
            arr[i]=arr[j];
            arr[j]=temp1;
        }
        int temp2 = arr[left];
        arr[left]=arr[j];
        arr[j]=temp2;
        return j;
    }

    public static void main(String[] args) {
        int[] arr={43,24,52,66,42,12,1,44};
        quickSOrt(arr);
        System.out.println();
    }
}
