package unionfind;

/**
 * @ClassName UnionFindOne
 * @Description 由孩子指向父亲的树
 * @Author admin
 * @Date 2020-12-24 11:12
 * @Version 1.0
 */
public class UnionFindFour implements UF {

    private int[] parent;
    private int[] rank;// 树的高度

    public UnionFindFour(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;// 每个元素对应的集合的编号都是不同的
            rank[i] = 1;
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
        // 基于树的高度的优化 rank


        if (rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
            // p的深度小于q的深度，p嫁接到q时，不需要维护高度
        }else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }else {// 高度一致的情况
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
