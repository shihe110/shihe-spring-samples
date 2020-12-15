package maxheap;

import array.Array;

import java.util.Random;

/**
 * @ClassName MaxHeap
 * @Description 底层使用动态数组实现最大堆
 * @Author admin
 * @Date 2020-12-09 17:26
 * @Version 1.0
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引-一个节点父节点的索引
    private int parent(int index){
        if (index == 0){
            throw  new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引-一个节点左孩子的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引-一个节点右孩子的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }
    // 向堆中添加一个元素
    public void add(E e){
        data.addLast(e);
        // 元素上浮，index为数组最后添加元素的下标
        siftUp(data.getSize() - 1);
    }
    // 元素上浮
    private void siftUp(int k) {
        // 循环判断该元素和他的父节点元素的大小来确定是否上浮，堆不为空
        // k > 0堆不为null，其父节点和元素比较要小的话确定上浮
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    // 从堆中取出元素，并下沉操作维护堆的性质
    public E extractMax(){
        E ret = findMax();
        // 删除
        data.swap(0, data.getSize() - 1);// 堆顶元素和最末元素交换位置
        data.removeLast();// 删除交换后的堆末元素-即原堆顶元素
        // 下沉操作
        siftDown(0);
        // 返回结果
        return ret;
    }
    // 下沉
    private void siftDown(int k) {
        // 给定k节点的有左孩子，即左孩子的下标比size要小，如果比size大即越界
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            // j的左右孩子比较 右孩子大--判断左右孩子大小，取大的那个
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);// j++;
            }
            if (data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }else {
                data.swap(k, j);
                k = j;
            }
        }
    }
    // 查看堆中最大元素-堆顶元素
    public E findMax(){
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }
    // 取出堆中最大元素，并替换成e（replace操作 即替换堆顶元素并维护堆的属性）
    public E replace(E e){
        E ret = findMax();
        // 替换堆顶元素
        data.set(0, e);
        // Sift Down 下沉操作
        siftDown(0);
        return ret;
    }
    // heapify
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if(arr[i - 1] < arr[i]){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap complated.");
    }
}
