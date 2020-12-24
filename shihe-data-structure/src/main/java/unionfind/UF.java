package unionfind;

/**
 * @InterfaceName UF
 * @Description 并查集接口
 * @Author admin
 * @Date 2020-12-24 11:00
 * @Version 1.0
 */
public interface UF {

    // 两个元素是否相连
    boolean isConnected(int p, int q);

    // 并在一起操作
    void unionElements(int p, int q);

    int getSize();


}
