package SortAlgorithm;

/***
 * 冒泡排序
 *思想：每次虚幻，若j的元素大于j+1的元素，则交换。每轮元素交换后，最后一个元素的位置固定。
 */
public class BubbleSort {
    public static void bubbleSort(Comparable[] arr){
        int len = arr.length;
        for(int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j].compareTo(arr[j+1])>0){
                    Comparable temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3,5,2,1,86,43,22};
        bubbleSort(arr);
        System.out.println();
    }
}
