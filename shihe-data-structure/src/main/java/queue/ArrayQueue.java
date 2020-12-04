package queue;

import array.Array;

/**
 * 数组队列
 * @Date 2020-12-04 11:17
 * @Version 1.0
 */
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this.array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队操作的时间复杂度是O(n)的，因array的removeFirst操作的时间复杂度是O(n)
     * @return
     */
    @Override
    public E dequeue() {
        return (E) array.removeFirst();
    }

    @Override
    public E getFront() {
        return (E) array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 0){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
