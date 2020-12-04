package sort;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author admin
 * @Date 2020-12-04 10:53
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,3,9,7,4};
        BubbleSort bs = new BubbleSort();
        int[] ints = bs.bubbleSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }

    public int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]<arr[j]){
                    exchange(arr,i,j);
                }
            }
        }
        return arr;
    }

    private void exchange(int[] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
