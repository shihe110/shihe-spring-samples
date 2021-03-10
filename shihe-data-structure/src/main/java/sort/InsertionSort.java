package sort;

/**
 * @ClassName InsertionSort
 * @Description TODO
 * @Author admin
 * @Date 2021-01-19 16:03
 * @Version 1.0
 */
public class InsertionSort {

    public int[] insertionSort(int[] arr){
        // i从1开始，0自然有序
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];// 记录当前数据

            int j = i;
            while (j>0 && temp<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            if (j != i){
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,9,7,4,6,8,2};
        InsertionSort s = new InsertionSort();
        int[] ints = s.insertionSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
