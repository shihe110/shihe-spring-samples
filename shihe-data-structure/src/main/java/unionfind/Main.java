package unionfind;

import java.util.Random;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-12-24 14:13
 * @Version 1.0
 */
public class Main {

    private static double testUF(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            uf.unionElements(p,q);
        }

        for (int i = 0; i < m; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            uf.isConnected(p,q);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
       /* UnionFindOne one = new UnionFindOne(size);
        UnionFindTwo two = new UnionFindTwo(size);*/
        UnionFindThree three = new UnionFindThree(size);
        UnionFindFour four = new UnionFindFour(size);
        UnionFindFive five = new UnionFindFive(size);
        UnionFindSix six = new UnionFindSix(size);

        /*double v = testUF(one, m);
        System.out.println("UnionFind one cost time is "+v +" s");

        double v1 = testUF(two, m);
        System.out.println("UnionFind two cost time is "+ v1 + " s");
*/
        double v2 = testUF(three, m);
        System.out.println("UnionFind three cost time is "+ v2 +" s");

        double v3 = testUF(four, m);
        System.out.println("UnionFind four cost time is "+ v3 +" s");

        double v4 = testUF(five, m);
        System.out.println("UnionFind five cost time is "+ v4 +" s");

        double v5 = testUF(six, m);// 递归开销
        System.out.println("UnionFind six cost time is "+ v5 +" s");

    }
}
