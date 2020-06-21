package com.lk.leecode.code;

/**
 * 环形链表  给定一个链表，判断链表中是否有环。
 */
public class Leecode21 {
    /**
     * 关键字：链表 双指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
    }
}
