import arcturus.util.ListNode;
import arcturus.util.TreeNode;

public class Solution1 extends Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/rotate-list/description/</url>
     * 解：
     * 先获得链表长度，然后将指针移动到length - k % length处，改变链接方式即可
     * @param head
     * @param k
     * @return
     */
    @Override
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) return head;
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode node = phead, tail = phead;
        int count = 0;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        for (int i = count - k % count; i > 0; i--) {
            node = node.next;
        }
        tail.next = phead.next;
        phead.next = node.next;
        node.next = null;
        return phead.next;
    }
}
