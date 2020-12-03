/**
 * @ClassName Array
 * @Description TODO
 * @Author admin
 * @Date 2020-12-03 10:06
 * @Version 1.0
 */
public class Array<E> {
    private E[] data;
    private int size;
    // 传入容量构造数组
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
    // 无参构造，默认capacity为8
    public Array() {
        this(8);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    // 向数组末尾添加元素
    public void addLast(E e){
        /*if (size==data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full");
        }
        data[size] = e;
        size ++;*/
        add(size,e);
    }
    // 向指定位置添加元素
    public void add(int index, E e){
        /*if (size==data.length){
            throw new IllegalArgumentException("Add failed. Array is full");
        }*/
        // index必须合法
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index>=0 or index<=size");
        }
        if (size == data.length){
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }
    // 向第0个位置添加元素
    public void addFirst(E e){
        add(0,e);
    }
    // 获取一个元素
    E get(int index){
        if (index < 0 || index >= size){
            new IllegalArgumentException("Get failed, Index is illegal");
        }
        return data[index];
    }
    // 修改指定位置元素
    void set(int index, E e){
        if (index < 0 || index >= size){
            new IllegalArgumentException("Set failed, Index is illegal");
        }
        data[index] = e;
    }
    // 是否包含
    boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }
    // 查找给定元素在数组中的索引,找不到返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }
    // 删除指定位置的元素,从0开始
    E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Del failed, Index is illegal");
        }

        E ret = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        size --;
        data[size] = null;// 垃圾回收 loitering Objects 不同于memory leak
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }
    // 删除第0个元素
    E removeFirst(){
        return remove(0);
    }
    // 删除最后一个元素
    E removeLast(){
        return remove(size -1);
    }
    // 如果有重复e的话，只删除第一个e
    void removeElement(E e){
        int index = find(e);
        if (index!=-1){
            remove(index);
        }
    }
    // 扩缩容
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 17; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.removeLast();
        arr.removeLast();
        System.out.println(arr);

    }
}
