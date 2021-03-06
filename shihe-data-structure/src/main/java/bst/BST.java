package bst;

import java.util.*;

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
        // 删除根节点为root的树的最小值，并返回该树的根节点
        root = removeMin(root);
        return e;
    }

    private Node removeMin(Node node) {
        // 递归出口-当前以node为根的节点已经走到最左端-叶子节点
        if (node.left == null){
            // 该根节点可能有右节点-保存右节点
            Node rightNode = node.right;
            // 删除节点node即该节点已经是最左节点但可能有右子树-将其删除即将该节点断开连接right是其作为根节点唯一对外的连接 赋null即删除
            node.right = null;
            size --;
            // 根节点node.right=null脱离树结构后，新的根节点为rightNode
            return rightNode;
        }
        // 递归调用-根节点node，该节点node还有左孩子
        // 即对node.left子树调用其删除最小节点递归函数
        node.left = removeMin(node.left);// removeMin(node.left)返回node.left的根节点和原根节点node连接-即node.left=返回节点
        // 根节点任然为node
        return node;
    }
    // 删除二分搜索树种最大元素
    public E removeMax(){
        E max = maxmuum();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        // 递归出口-已经为最大右子树
        if (node.right == null){
            // 承接可能存在的左子树
            Node leftNode = node.left;
            // 删除节点
            node.left = null;
            size --;
            // 返回根节点
            return leftNode;
        }
        // 该节点不是最大节点
        // 删除node有子树中的最大值，并返回其子根节点，并连接原节点
        node.right = removeMax(node.right);
        // 总根节点为node
        return node;
    }
    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        // 在root为根节点的二分搜索树中删除e
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        // 在node为根的二分搜索树中没找到e
        if (node == null){
            return null;
        }
        // 待删除节点在左子树
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        // 待删除节点在右子树
        else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        // 待删除节点-为根节点
        // 后驱删除
        else {//(e.compareTo(node.e) == 0)
            // 待删除节点左子树为null
            if (node.left == null){
               Node rightNode = node.right;
               node.right = null;
               size --;
               return rightNode;
            }
            // 待删除节点右子树为null
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树都不为null
            // 找到比删除节点大的最小节点，即删除节点右子树的最小节点
            Node successor = minimum(node.right);
            // successor-待删除节点的后继节点-替换要删除的节点
            // 后继节点的右孩子-是待删除节点的右子树删除最小节点的后的子树
            successor.right = removeMin(node.right);
            // removeMin中做了size-- 但其实被successor承接了，并没有被删除，所以要加回来
            size ++;
            // 后继节点的左孩子-是删除节点的左孩子
            successor.left = node.left;

            // 删除待删除节点
            node.left = node.right = null;
            size --;

            return node;
        }
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
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()){
            Integer min = bst.removeMin();
            nums.add(min);
        }

        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1)>nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin is ok");
        /*int[] nums = {3, 5, 4, 6, 8, 2};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }*/

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
//        System.out.println("***************");
       /* bst.removeMin();
        bst.preOrderNR();*/
        /*Integer integer = bst.removeMin();
        System.out.println(integer);*/
    }

}
