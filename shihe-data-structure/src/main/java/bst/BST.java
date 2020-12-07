package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName BST - Binary Search Tree
 * @Description TODO
 * @Author admin
 * @Date 2020-12-07 11:05
 * @Version 1.0
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    // 向二分搜索树添加新元素e
    public void add(E e){
        /*if (root == null){
            root = new Node(e);
            size ++;
        }else {
            add(root, e);
        }*/
        root = add(root, e);
    }
    // 向以node为根的二分搜索树插入元素e，返回树的根，递归写法
    private Node add(Node node, E e) {
        /**
         * 递归的最小单元为：null节点二叉树
         */
        // 递归出口
        if (node == null){
            size ++;
            return new Node(e);
        }
        // 递归调用（出口上一级）
        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }

        return node;
        // 递归出口 终止条件
        // 排除值相等的情况
        /*if (e.equals(node.e)){
            return;
        }
        //
        else if (e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }else if (e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }
        // 递归调用
        if (e.compareTo(node.e) < 0){
            add(node.left, e);
        }else {
            add(node.right, e);
        }*/
    }
    // 查询二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }
    // 递归查询，以root为根节点的二分搜索树中是否包含e
    private boolean contains(Node node, E e) {
        // 递归出口
        if (node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
    }
    // 前序遍历
    public void preOrder(){
        preOrder(root);
    }
    // 前序遍历
    private void preOrder(Node node) {
        // 递归出口
        if (node == null){
            return;
        }
        // 访问根节点
        System.out.println(node.e);
        // 递归调用
        preOrder(node.left);
        preOrder(node.right);
    }
    // 非递归前序遍历--系统栈方式
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }
    // 中序遍历--树中的排序结果
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        // 遍历左子树
        inOrder(node.left);
        // 根节点
        System.out.println(node.e);
        // 遍历右节点
        inOrder(node.right);
    }
    // 后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        // 递归出口
        if (node == null){
            return;
        }
        // 左子树遍历
        postOrder(node.left);
        // 右子树遍历
        postOrder(node.right);
        // 根节点遍历
        System.out.println(node.e);
    }
    // 二分搜索树的层序遍历--可以更快的找到要查询的元素-用在查询上（更快）
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                q.add(cur.left);
            }
            if (cur.right != null){
                q.add(cur.right);
            }
        }
    }
    // 寻找二分搜索树的最小元素
    public E minimum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        Node res = minimum(root);
        return res.e;
    }

    private Node minimum(Node node) {
        // 递归出口
        if (node.left == null){
            return node;
        }
        // 递归调用
        return minimum(node.left);
    }
    public E maxmuum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        return maxmuum(root).e;
    }

    private Node maxmuum(Node node) {
        // 递归出口
        if (node.right == null)
            return node;
        // 递归调用
        return maxmuum(node.right);
    }
    // 删除二分搜索树中的最小值元素
    public E removeMin(){
        E e = minimum();
        root = removeMin(root);
        return e;
    }

    private Node removeMin(Node node) {
        // 递归出口
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root ,0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        // 递归调用
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {3, 5, 4, 6, 8, 2};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }

       /* System.out.println(bst.contains(3));
        bst.preOrder();
        System.out.println("-----------");
        bst.inOrder();
        System.out.println("---------------");
        bst.postOrder();
        System.out.println("----------");
        bst.preOrderNR();
        System.out.println("------------");
        bst.levelOrder();*/
      /*  System.out.println("========");
        Integer minimum = bst.minimum();
        System.out.println(minimum);
        System.out.println("--------");
        System.out.println(bst.maxmuum());*/
        System.out.println("***************");
        bst.removeMin();
        bst.preOrderNR();
    }

}
