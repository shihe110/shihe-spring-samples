package queue;

import java.util.Random;

/**
 * @ClassName Main 测试两种队列在不同数据量下的效率
 * @Description TODO
 * @Author admin
 * @Date 2020-12-04 15:04
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        int opCount = 10000000;
       /* Queue<Integer> arrayQueue = new ArrayQueue<>();
        double v = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time: "+v + " s");*/

        System.out.println("----------------------");
        Queue<Integer> loopQueue = new LoopQueue<>();
        double v1 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time: "+v1 + " s");


        System.out.println("----------------------");
        Queue<Integer> linkQueue = new LinkedListQueue<>();
        double v2 = testQueue(linkQueue, opCount);
        System.out.println("LinkedQueue time: "+v2 + " s");

    }


    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random r = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(r.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
