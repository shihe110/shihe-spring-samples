package segment;

/**
 * @InterfaceName Merger
 * @Description 融合左右两个线段接口-用户自定义业务逻辑
 * @Author admin
 * @Date 2020-12-18 14:54
 * @Version 1.0
 */
public interface Merger<E> {
    E merge(E a, E b);
}
