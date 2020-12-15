package maxheap;

import java.util.Random;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-12-15 16:52
 * @Version 1.0
 */
public class Main {
    private static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify){
            maxHeap = new MaxHeap<Integer>(testData);
        }else {
            maxHeap = new MaxHeap<Integer>();
            for (Integer testDatum : testData) {
                maxHeap.add(testDatum);
            }
        }
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < testData.length; i++) {
            if(arr[i - 1] < arr[i]){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap complated.");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        // 准备测试数据
        int n = 1000000;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        // 调用测试
        double v = testHeap(arr, false);
        System.out.println("No heapify: "+ v + " s");


        double v1 = testHeap(arr, true);
        System.out.println("Use heapify: "+ v1 + " s");

    }
}
