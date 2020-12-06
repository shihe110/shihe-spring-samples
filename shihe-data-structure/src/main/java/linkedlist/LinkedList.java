package linkedlist;

import java.util.ArrayList;

/**
 * @InterfaceName LinkedList
 * @Description TODO
 * @Author admin
 * @Date 2020-12-04 15:42
 * @Version 1.0
 */
public class LinkedList<E> {
    // 内部类 链表的节点（组成链表的最小单元）
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e, null);
        }
        public Node(){
            this(null, null);
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }
    // 虚拟头节点
    private Node dummyHead;
    private int size;

    // 空链表-虚拟头节点
    public LinkedList(){
//        dummyHead = new Node(null, null);
        dummyHead = new Node();
        size = 0;
    }
    // 链表反转
    public LinkedList<E> reverse(){
        LinkedList<E> linkedList = new LinkedList<>();
        Node prev = dummyHead;
        for (int i = 0; i < size; i++) {
            prev = prev.next;
            linkedList.addFirst(prev.e);
        }
        return linkedList;
    }

    // 返回链表中的元素个数
    public int getSize(){
        return size;
    }
    // 返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    // 在链表中间index位置添加一个新的元素e
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        // prev节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 新建节点 断开 挂载
        prev.next = new Node(e, prev.next);
        size ++;
        /*if (index == 0){// 链表头
            addFirst(e);
        }else {
            Node prev = head;
            for (int i = 0; i < index -1; i++) {
                prev = prev.next;
            }
            *//*Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*//*
            prev.next = new Node(e, prev.next);

            size ++;
        }*/
    }
    // 在链表头添加新元素e
    public void addFirst(E e){
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/
        // 一句话写法
        /*head = new Node(e, head);
        size ++;*/
        add(0, e);
    }
    // 在链表末尾添加一个元素e
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 链表的查询和修改都不是常用操作
     * @param index
     * @return
     */
    // 获取index位置节点元素
    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    // 获取链表第一个元素
    public E getFirst(){
        return get(0);
    }
    // 获取链表最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改index位置的元素为e
    public void set(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表中是否存在元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur.e != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    // 删除指定位置index节点的元素 不常用操作
    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        // 获取index之前的节点
        Node prev = dummyHead;// 不是从dummyHead开始的，因为可能删除第0个元素
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        // 将index节点挂载到下个节点
        prev.next = retNode.next;
        /*cur.next = cur.next.next; 是错误的相当于指针指向了下一个节点*/
        retNode.next = null;
        // 维护size
        size --;
        return retNode.e;
    }
    // 删除链表第一个元素
    public E removeFirst(){
        return remove(0);
    }
    // 删除链表最后一个元素
    public E removeLast(){
        return remove(size -1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        /*Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }*/
        for (Node cur = dummyHead.next; cur != null; cur = cur.next){
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList = linkedList.reverse();
        System.out.println(linkedList);

        /*linkedList.add(2, 132);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);*/
    }
}
