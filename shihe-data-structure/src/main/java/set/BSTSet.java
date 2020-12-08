package set;

import bst.BST;

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
}
