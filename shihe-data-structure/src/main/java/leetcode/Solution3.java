package leetcode;

/**
 * 未使用虚拟头节点，单独处理头结点版本
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val){
        /*
        // 最基本的情况-即问题规模最小的情况求解
        // 本身是null链表，直接返回null或head
        if (head == null){
            return null;
        }else {
            // 问题编程head节点和head以后的所有节点组成的子链表的问题
            // 求解子链表
            ListNode res = removeElements(head.next, val);
            // 解决head节点和子链表的问题
            if (head.val == val){
                return res;
            }else {
                head.next = res;
                return head;
            }
        }*/
        /**
         * 更简洁写法
         */
        if (head == null){
            return null;
        }else {
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        Solution3 solution = new Solution3();
        ListNode retNode = solution.removeElements(head, 6);
        System.out.println(retNode);
    }
}
