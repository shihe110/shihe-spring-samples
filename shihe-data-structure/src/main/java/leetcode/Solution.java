package leetcode;

import queue.LinkedListQueue;

/**
 * 未使用虚拟头节点，单独处理头结点版本
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val){
        // head就是要删除的节点val，删除一个节点后，下一个节点还等于val
        while (head !=null && head.val == val){
            // head就是要删除的节点
            ListNode delNode = head;
            head = head.next;// head后移一位，即head移动前的节点就被遗弃了
            delNode.next = null;// 处理待删除节点的loitering objects问题
            /**
             * 简化写法，不处理loitering objects问题
             * head = head.next;
             */
        }
        // 如果这个链表所有节点都等于val，即都要删除则执行到此时，head就为null了
        if (head == null){
            return head;// 即return null
        }
        // 处理链表中间的节点值为val的节点删除
        // 找到待删除元素的前一个节点，将前一个节点挂载到后一个节点，要删除节点断开链接并置为空
        ListNode prev = head;
        while (prev.next != null){// prev不是最后一个节点(即：prev的next指向null）
            // prev的下一个节点是待删除节点
            if (prev.next.val == val){
                // prev节点的下一个节点是val要删除节点
                ListNode delNode = prev.next;
                // prev的next 挂载到待删除节点的下一个节点
                prev.next = delNode.next;
                // 将待删除节点，断开链接。
                delNode.next = null;
                /**
                 * 简化写法,越过下一节点挂载下下个节点
                 * prev.next = prev.next.next;
                 */
            }
            // prev的下一个节点不是但删除节点
            else {
                // prev后移一位
                prev = prev.next;
            }
        }
        // 返回head，链表的头（链表必须知道头才能知道全貌）
        return head;
    }

    /**
     * 本地测试
     */
    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        Solution solution = new Solution();
        ListNode retNode = solution.removeElements(head, 6);
        System.out.println(retNode);
    }
}
