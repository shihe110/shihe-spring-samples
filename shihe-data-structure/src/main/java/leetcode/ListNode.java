package leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    // 链表节点构造函数 使用array作为构造参数，创建一个链表，当前的ListNode为链表的头节点
    public ListNode(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty.");
        }
        // 该当前节点赋值，数组的第一个元素
        this.val = arr[0];
        // 设置标记节点
        ListNode cur = this;
        // 循环数组，新建节点并挂载
        for (int i = 1; i < arr.length; i++) {
            // 新建并挂载节点
            cur.next = new ListNode(arr[i]);
            // 标记节点后移
            cur = cur.next;
        }
    }

    /**
     * 以当前节点为头节点的链表字符串
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
