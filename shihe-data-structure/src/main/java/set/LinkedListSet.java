package set;

import linkedlist.LinkedList;

/**
 * @ClassName LinkedListSet
 * @Description TODO
 * @Author admin
 * @Date 2020-12-08 16:44
 * @Version 1.0
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }


}
