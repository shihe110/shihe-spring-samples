package set;

/**
 * @ClassName Set
 * @Description TODO
 * @Author admin
 * @Date 2020-12-08 16:27
 * @Version 1.0
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
