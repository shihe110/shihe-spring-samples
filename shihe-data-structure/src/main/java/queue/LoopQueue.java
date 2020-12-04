package queue;

import java.lang.Object;
/**
 * @ClassName LoopQueue 循环队列
 * @Description TODO
 * @Author admin
 * @Date 2020-12-04 13:31
 * @Version 1.0
 */
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;

    }

    public LoopQueue(){
        this(8);
    }
    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public int getSize() {
        return size;
    }
    // front==tail时队列为空
    @Override
    public boolean isEmpty() {
        return front==tail;
    }
    // (tail+1)%c==front时队列已满
    public boolean isFull(){
        return (tail+1) % data.length == front;
    }

    /**
     * 入队操作可能触发扩容，所以均摊时间复杂度为 O(1)
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队操作可能触发扩容，所以均摊时间复杂度为 O(1)
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        // 判断扩缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);// 因capacity不能等于0
        }
        return ret;
    }
    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n",size,getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            // 不是最后一个元素
            if ((i + 1) % data.length != tail){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
