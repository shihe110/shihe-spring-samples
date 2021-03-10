package sort;

import jdk.nashorn.tools.Shell;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author admin
 * @Date 2021-01-20 10:12
 * @Version 1.0
 */
public class ShellSort {

    public int[] shellSort(int[] arr){
        int length = arr.length;
        int temp;

        for (int step = length / 2; step >= 1 ; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp){
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,9,7,4,6,8,2};
        ShellSort s = new ShellSort();
        int[] ints = s.shellSort(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
