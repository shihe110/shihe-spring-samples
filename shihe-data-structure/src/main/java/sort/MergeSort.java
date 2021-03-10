package sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author admin
 * @Date 2021-01-20 10:56
 * @Version 1.0
 */
public class MergeSort {
    public int[] sort(int[] arr){
        // 递归出口
        if (arr.length < 2){
            return arr;
        }
        // 取中间值将数组分割成两个
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        // 合并排序 递归调用
        return merge(sort(left), sort(right));
    }


    protected int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        // 排序合并两个数组
        while (left.length > 0 && right.length > 0){
            if (left[0] <= right[0]){
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        // 经过合并后，left数组还有数据的情况
        while (left.length >0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        // 经过合并后，right array 还有剩余数据的情况
        while (right.length >0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,9,7,4,6,8,2};
        MergeSort mergeSort = new MergeSort();
        int[] sort = mergeSort.sort(arr);
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i]+" ");
        }
    }
}
