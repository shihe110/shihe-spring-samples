package stack;

public interface Stack<E> {
    // 栈的size
    int getSize();
    // 是否为空
    boolean isEmpty();
    // 入栈
    void push(E e);
    // 出栈
    E pop();
    // 查看栈顶元素
    E peek();
}
