package SortAlgorithm;

/**
 * 选择排序
 * 思想：第一轮从所有元素中选最小的，与第一个交换；第二轮从第2个元素开始选最小的元素与第二个元素交换
 * 每轮排序从剩下待排序的元素中选最小的元素进行交换。
 * */
public class SelectSort {
    public static void selectSort(Comparable[] arr){
        if(arr==null){
            return;
        }
        for (int i=0;i<arr.length;i++){
            int min = i;//最小值的索引
            for (int j=i+1;j<arr.length;j++){
                if (arr[j].compareTo(arr[min])<0){
                    min=j;
                }
            }
            Comparable temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        String[] str = {"zad","dcd","egx","bdf"};
        Integer[] arr = {44,4,2,6,3,7,3,82,12};
        selectSort(str);
        selectSort(arr);
        System.out.println(str.toString());
    }
}
