package sort;

/**
 * @ClassName SelectionSort
 * @Description TODO
 * @Author admin
 * @Date 2021-01-19 15:17
 * @Version 1.0
 */
public class SelectionSort {
    
    public int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    min = j;
                }
            }
            if (i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,9,7,4,6,8,2};
        SelectionSort s = new SelectionSort();
        int[] ints = s.selectionSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
