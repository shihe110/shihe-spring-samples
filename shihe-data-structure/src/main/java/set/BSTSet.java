package set;

import bst.BST;
import map.FileUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @ClassName BSTSet
 * @Description TODO
 * @Author admin
 * @Date 2020-12-08 16:28
 * @Version 1.0
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;
    public BSTSet() {
        this.bst = new BST<>();
    }
    @Override
    public int getSize(){
        return bst.size();
    }
    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }
    @Override
    public void remove(E e) {
        bst.remove(e);
    }
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    public static void main(String[] args) {
        System.out.println("pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileUtil.readFile("F:\\shihe-spring-samples\\shihe-data-structure\\src\\main\\java\\map\\pride-and-prejudice.txt",words);

        BSTSet<String> set = new BSTSet<>();
        for (String word : words) {
            set.add(word);
        }
        System.out.println("total words "+set.getSize());
    }
}
