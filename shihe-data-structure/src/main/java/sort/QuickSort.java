package sort;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author admin
 * @Date 2021-01-21 10:21
 * @Version 1.0
 */
public class QuickSort {
    public int[] quickSort(int[] arr){
        return quickSort(arr,0,arr.length-1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right){
            int partitionIndex = partition(arr,left,right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]){
                swap(arr,i,index);
                index ++;
            }
        }
        swap(arr,pivot,index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int pivot, int i) {

    }


}
