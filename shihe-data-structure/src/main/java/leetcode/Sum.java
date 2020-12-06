package leetcode;

public class Sum {

    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l){
        if (l == arr.length){
            return 0;
        }else {
            return arr[l] + sum(arr, l + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int sum = sum(nums);
        System.out.println(sum);
    }
}
