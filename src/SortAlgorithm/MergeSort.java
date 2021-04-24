package SortAlgorithm;

//归并排序
public class MergeSort {
    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }
    public static void sort(int[] arr,int left ,int right, int[] temp){
        if (left<right){
            int mid = left+((right-left)>>1);
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }
    public static void merge(int[] arr,int left, int mid, int right, int[] temp){
        int i = left;
        int j= mid+1;
        int t=0;
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

    public static void main(String[] args) {
        int[] arr={43,24,52,66,42,12,1,44};
        mergeSort(arr);
        System.out.println();
    }
}
