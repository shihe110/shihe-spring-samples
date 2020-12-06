package leetcode;

/**
 * 未使用虚拟头节点，单独处理头结点版本
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val){
        // 创建虚拟头结点-为了使链表所有节点的处理逻辑统一，所以val值随意指定，因为我们永远不会访问该值
        ListNode dummyHead = new ListNode(-1);
        // 虚拟头节点挂载到head节点，将链表延长，即增加一个虚拟头结点
        dummyHead.next = head;

        // 设置标记节点，标记待删除节点的前一个节点
        ListNode prev = dummyHead;
        // 当前节点不是最后一个节点
        while (prev.next != null){
            // 虚拟节点的下一节点是要删除节点，即实际链表的第一个节点是要删除节点
            if (prev.next.val == val){
                // 虚拟节点越过下一个节点挂载（删除要删除节点）
                prev.next = prev.next.next;
            }
            // 虚拟节点下一个节点不是待删除节点
            else {
                // prev标记节点后移一位
                prev = prev.next;
            }
        }
        // 虚拟头结点是人为创造，为统一所有节点的处理逻辑
        // 所以真正要返回的头节点是虚拟头结点的下一个节点
        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        Solution2 solution = new Solution2();
        ListNode retNode = solution.removeElements(head, 6);
        System.out.println(retNode);
    }
}
