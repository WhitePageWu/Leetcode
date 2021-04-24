package SortAlgorithm;

/**
 * 希尔排序
 * 思想：按一定间隔，对每组进行直接插入排序，然后缩小间隔，重复直接插入排序，直到间隔为1
 * */
public class ShellSort {
    public static void shellSort(Comparable[] arr){
        int len = arr.length;
        int h = 1;
        while (h<len/3){
            h=3*h+1;
        }
        while (h>=1){
            for (int i=h;i<len;i++){
                for (int j=i;j>=h&&arr[j].compareTo(arr[j-h])<0;j-=h){
                    Comparable temp = arr[j];
                    arr[j]=arr[j-h];
                    arr[j-h]=temp;
                }
            }
            h/=3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {44,4,2,6,3,7,5,82,12};
        shellSort(arr);
        System.out.println();
    }
}
