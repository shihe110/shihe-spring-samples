package unionfind;

/**
 * @ClassName UnionFindOne
 * @Description 由孩子指向父亲的树
 * @Author admin
 * @Date 2020-12-24 11:12
 * @Version 1.0
 */
public class UnionFindThree implements UF {

    private int[] parent;
    private int[] sz;// 记录树节点元素个数（不同于树的深度）

    public UnionFindThree(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;// 每个元素对应的集合的编号都是不同的
            sz[i] = 1;
        }
    }
    // O(h)复杂度
    // 其实找的是树的根节点
    private int find(int p){
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p]){
            p = parent[p];
        }
        return p;// 找到p的根节点
    }
    // pq两个元素 所属的集合编号是否相等 即两个元素是否连接
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 两个元素 归并到同一个集合
    @Override
    public void unionElements(int p, int q) {
        // 根节点
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        // 基于树节点的元素个数的优化
        if (sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot]+=sz[pRoot];// 节点数量处理
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot]+=sz[qRoot];
        }
        // 这种优化产生一个问题，树的节点数量不能完全反应树的高度，如一个高度为二五叉树，和一个高度为三的一叉树，
        // 对于五叉树的叶子节点而言，比一叉树的叶子节点的元素个数要大，但实际上深度却小，安照以上的优化逻辑，会将一叉嫁接到二叉树上
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
