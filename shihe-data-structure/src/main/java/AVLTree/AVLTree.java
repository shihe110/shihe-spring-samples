package AVLTree;

import map.BSTMap;

/**
 * @ClassName AVLTree
 * @Description TODO
 * @Author admin
 * @Date 2020-12-24 17:26
 * @Version 1.0
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }
    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private int getHeight(Node node){
        if (node == null){
            return 0;
        }
        return node.height;
    }
    // 获取节点node的平衡因子
    private int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }else {
           return getHeight(node.left) - getHeight(node.right);
        }
    }
    // 右旋转
    //      y               x
    //     / \            /   \
    //    x  T4          z     y
    //   / \            / \   / \
    //  z  T3          T1 T2 T3 T4
    // / \
    //T1 T2
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;
        // 右旋转
        x.right = y;
        y.left = T3;
        // 更新高度值
        y.height = 1 + Math.max(getHeight(y.left),getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left),getHeight(x.right));

        return x;
    }
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T3 = x.left;
        // 左旋转
        x.left = y;
        y.right = T3;
        // 维护高度值
        y.height = 1 + Math.max(getHeight(y.left),getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left),getHeight(x.right));

        return x;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null){
            size ++;
            return new Node(key, value);
        }
        // 左子树递归
        if (key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }else {
            node.value = value;
        }
        // 更新height 计算当前节点node的高度
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1){// 不平衡了
            System.out.println("该节点的平衡因子是"+balanceFactor);
        }
        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            // getBalanceFactor(node.left) >= 0 表示其左子树的高度大于其右子树高度 即树左倾斜
            // 平衡因子大于1的节点，将其左子树变成根节点，其变成其左子树节点的右子树，其左子树的右子树节点变成该节点的左子树
            return rightRotate(node);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        // LR 右子树比左子树高
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);// 左子树左旋变成LL
            return leftRotate(node);
        }
        // RL 左子树比右子树高
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return rightRotate(node);
        }
        return node;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){
            root = remove(root, key);
            return root.value;
        }
        return null;
    }
    // 删除以node为根的二分搜索树中 key=key的节点
    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        Node retNode;
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            retNode = node;
        }else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        }else{// == node为要删除节点
            // node没有右子树,即要删除该节点并返回该节点的左子树
            if (node.right == null){
                // 待返回左子树
                Node leftNode = node.left;
                // 断开该节点
                node.left = null;
                size --;
                retNode = leftNode;
            }
            // node没有左子树
            else if (node.left == null){
                // 要返回的右子树
                Node rightNode = node.right;
                // 断开
                node.right = null;
                size --;
                retNode = rightNode;
            }else {
                // 左右子树都不为null
                // 后继节点-在node的右子树找最小节点
                Node successor = minmum(node.right);
                // 后继节点的右子树为node删除最小节点后的右子树
               // successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);

                successor.left = node.left;
                // 删除最小节点
                node.left = node.right = null;
                // 要删除节点
                retNode = successor;
            }
        }
        if (retNode == null){
            return null;
        }
        // 更新height 计算当前节点node的高度
        retNode.height = 1 + Math.max(getHeight(retNode.left),getHeight(retNode.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0){
            // getBalanceFactor(node.left) >= 0 表示其左子树的高度大于其右子树高度 即树左倾斜
            // 平衡因子大于1的节点，将其左子树变成根节点，其变成其左子树节点的右子树，其左子树的右子树节点变成该节点的左子树
            return rightRotate(retNode);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0){
            return leftRotate(retNode);
        }
        // LR 右子树比左子树高
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
            retNode.left = leftRotate(retNode.left);// 左子树左旋变成LL
            return leftRotate(retNode);
        }
        // RL 左子树比右子树高
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return rightRotate(retNode);
        }
        return retNode;
    }

    private Node removeMin(Node node) {
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node minmum(Node node) {
        if (node.left == null)
            return node;
        return minmum(node.left);
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesnot exist!");

        node.value = newValue;
    }

    private Node getNode(Node node, K key){
        // 递归出口
        if (node == null){
            return null;
        }
        // 递归调用
        /*if (key.compareTo(node.key) < 0){
            node.left = getNode(node.left, key);
            return node.left;
        }else if (key.compareTo(node.key) > 0){
            node.right = getNode(node.right, key);
            return node.right;
        }else {
            return node;
        }*/
        if (key.compareTo(node.key) == 0){
            return node;
        }else if (key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else {
            return getNode(node.right, key);
        }
    }
}
