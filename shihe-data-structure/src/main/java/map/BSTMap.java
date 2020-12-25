package map;

import bst.BST;

/**
 * @ClassName BSTMap
 * @Description TODO
 * @Author admin
 * @Date 2020-12-09 10:32
 * @Version 1.0
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node left;
        public Node right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private int size;
    private Node root;

    public BSTMap(){
        root = null;
        size = 0;
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
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
      return node;
    }

    @Override
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
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }else{// == node为要删除节点
            // node没有右子树,即要删除该节点并返回该节点的左子树
            if (node.right == null){
                // 待返回左子树
                Node leftNode = node.left;
                // 断开该节点
                node.left = null;
                size --;
                return leftNode;
            }
            // node没有左子树
            if (node.left == null){
                // 要返回的右子树
                Node rightNode = node.right;
                // 断开
                node.right = null;
                size --;
                return rightNode;
            }
            // 左右子树都不为null
            // 后继节点-在node的右子树找最小节点
            Node successor = minmum(node.right);
            // 后继节点的右子树为node删除最小节点后的右子树
            successor.right = removeMin(node.right);

            successor.left = node.left;
            // 删除最小节点
            node.left = node.right = null;
            // 要删除节点
            return successor;
        }
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

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
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
