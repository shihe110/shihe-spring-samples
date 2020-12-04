package queue;

import array.Array;

/**
 * @InterfaceName Queue
 * @Description TODO
 * @Author admin
 * @Date 2020-12-04 11:18
 * @Version 1.0
 */
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
