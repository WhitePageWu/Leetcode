package SortAlgorithm;


/**
 * 插入排序
 * 思想：对于第i个元素，若当前元素比前面的元素小，则交换，否则，停止交换。
 * */
public class InsertSort {
    public static void insertSort(Comparable[] arr){
        if (arr==null){
            return;
        }
        //交换相同元素
//        for (int i=1;i<arr.length;i++){
//            for (int j=i;j>0;j--){
//                if (arr[j].compareTo(arr[j-1])<0){
//                    Comparable temp = arr[j];
//                    arr[j]=arr[j-1];
//                    arr[j-1]=temp;
//                }
//            }
//        }
        //右移动元素
        for (int i=1;i<arr.length;i++){
            Comparable temp =arr[i];
            int j;
            for (j=i;j>0&&temp.compareTo(arr[j-1])<0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=temp;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3,5,2,1,86,43,22};
        insertSort(arr);
        System.out.println();
    }
}
