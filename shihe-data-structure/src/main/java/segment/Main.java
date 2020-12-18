package segment;

import jdk.nashorn.internal.ir.CallNode;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-12-18 15:58
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Integer[] arr = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr,(a, b) -> a + b);
        System.out.println(segmentTree);

        Integer query = segmentTree.query(0, 2);
        System.out.println(query);
    }
}
