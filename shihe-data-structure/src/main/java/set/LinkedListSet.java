package set;

import linkedlist.LinkedList;

import java.util.ArrayList;

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

    public static void main(String[] args) {
        System.out.println("傲慢与偏见");
        ArrayList<String> words = new ArrayList<>();
        FileUtil.readFile("F:\\shihe-spring-samples\\shihe-data-structure\\src\\main\\java\\set\\pride-and-prejudice.txt", words);
        System.out.println("Total words "+words.size());

        LinkedListSet<String> set = new LinkedListSet<>();
        for (String word : words) {
            set.add(word);
        }
        System.out.println("different words "+set.getSize());
    }

}
