package map;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LinkedListMap<K, V> implements Map<K, V> {
    // map基于链表的实现-链表内部类
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){
            this(key, null, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString()+" : "+value.toString();
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }
    // 通过key获取对应的节点
    public Node getNode(K key){
        // cur作为标志位指向第一个节点
        Node cur = dummyHead.next;
        // 当前节点不为null
        while (cur != null){
            // 当前节点是key对应节点则结束循环返回该节点
            if (cur.key.equals(key)){
                return cur;
            }
            // cur标志位后移一位
            cur = cur.next;
        }
        // 遍历完整个链表仍未找到对应key值则返回null
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }else{
            // 根据自己的设计确定，此时传来的value是真正想要的，或者抛出一个错误
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;

    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileUtil.readFile("F:\\shihe-spring-samples\\shihe-data-structure\\src\\main\\java\\map\\pride-and-prejudice.txt",words);

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            if (map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }
            else
                map.put(word, 1);
        }
        System.out.println("pride :"+map.get("pride"));
        System.out.println("prejudice :"+map.get("prejudice"));
    }
}
