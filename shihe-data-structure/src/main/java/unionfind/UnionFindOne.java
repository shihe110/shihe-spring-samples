package unionfind;

/**
 * @ClassName UnionFindOne
 * @Description TODO
 * @Author admin
 * @Date 2020-12-24 11:12
 * @Version 1.0
 */
public class UnionFindOne implements UF {

    private int[] id;

    public UnionFindOne(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;// 每个元素对应的集合的编号都是不同的
        }
    }

    private int find(int p){
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }
    // pq两个元素 所属的集合编号是否相等 即两个元素是否连接
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 两个元素 归并到同一个集合
    @Override
    public void unionElements(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid){
            return;
        }
        // 将所有pid的编号改成qid
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid){
                id[i] = qid;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
