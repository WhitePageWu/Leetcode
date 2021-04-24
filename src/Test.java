import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Test {

    //插入排序
    public static void insertSort(int[] arr){
        for (int i=0;i<arr.length;i++){
//            for (int j = i;j>0;j--){
//                if (arr[j]<arr[j-1]){
//                    int temp = arr[j];
//                    arr[j]=arr[j-1];
//                    arr[j-1]=temp;
//                }
//            }
            int j =i;
            int temp = arr[j];
            for (;j>0&&temp<arr[j-1];j--){
                arr[j]=arr[j-1];
            }
            arr[j]=temp;
        }
    }
    //希尔排序
    public static void shellSort(int[] arr){
        int len = arr.length;
        int gap = 1;
        while (gap<len){
            gap=3*gap+1;
        }
        while (gap>=1){
            for (int i=gap;i<len;i++){
                for (int j=i;j>=gap;j-=gap){
                    if (arr[j]<arr[j-gap]){
                        int temp = arr[j];
                        arr[j]=arr[j-gap];
                        arr[j-gap]=temp;
                    }
                }
            }
            gap/=3;
        }
    }
    //选择排序
    public static void selectSort(int[]arr){
        for (int i=0;i<arr.length;i++){
            int min = i;
            for (int j =i+1;j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    //堆排序
    public static void heapSort(int[] arr){
        for (int i=arr.length-1;i>0;i--){
            maxHeap(arr,i);
            int temp = arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
        }
    }

    public static void maxHeap(int[] arr,int n){
        int child;
        for (int i=(n-1)/2;i>=0;i--){
            child=2*i+1;
            if (child!=n&&arr[child]<arr[child+1]){
                child++;
            }
            if (arr[i]<arr[child]){
                int temp = arr[i];
                arr[i]=arr[child];
                arr[child]=temp;
            }
        }
    }
    //归并排序
    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSortHelp(arr,0,arr.length-1,temp);
    }
    public static void mergeSortHelp(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid = left+((right-left)>>1);
            mergeSortHelp(arr,left,mid,temp);
            mergeSortHelp(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;
        int j=mid+1;
        int t = 0;
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            }else {
                temp[t++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[t++]=arr[i++];
        }
        while (j<=right){
            temp[t++]=arr[j++];
        }
        t=0;
        while (left<=right){
            arr[left++]=temp[t++];
        }
    }

    //快速排序
    public static void quickSort(int[] arr){
        quickSortHelp(arr,0,arr.length-1);
    }
    public static void quickSortHelp(int[] arr,int left,int right){
        if (left<right){
            int j = partition(arr,left,right);
            quickSortHelp(arr,left,j-1);
            quickSortHelp(arr,j+1,right);
        }
    }
    public static int partition(int[]arr,int left,int right){
        int i=left;
        int j = right+1;
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
        quickSort(arr);
        System.out.println("-----------");
    }
}
