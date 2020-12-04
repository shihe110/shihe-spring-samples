package stack;

public class TestStack {
    public static void main(String[] args) {
        int opsCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double v = testStack(arrayStack, opsCount);
        System.out.println("ArrayStack time: " + v + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double v1 = testStack(linkedListStack, opsCount);
        System.out.println("LinkedListStack time: " + v1 + " s");

        /**
         * 两种栈的时间复杂度是一样的都是O(1)级别的。
         * 数据较少时二者性能几乎看不出差异
         * 只有在数据量千万级别时-本机jdk1.8 测试arryStack大约快linkedListStack一倍左右。
         * 差距并不大。linkedListStack慢的原因在于存在大量的new操作，导致拖慢速度。
         */
    }

    public static double testStack(Stack stack, int opsCount){
        long startTime = System.nanoTime();
        for (int i = 0; i < opsCount; i++) {
            stack.push(i);
        }
        for (int i = 0; i < opsCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
