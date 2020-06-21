package com.lk.leecode.code;

import java.util.List;

/**
 * 链表排序
 */
public class Leecode39lianbiao {

    /**
     *1.判断递归出口
     *2.找中间点 cut
     *3.找到两条链表的最头
     */
    public ListNode sortList(ListNode head) {
        //递归出口
        if(head ==null|| head.next==null){
            return head;
        }
        //找中间的切点cut
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //中间点
        ListNode mid = slow.next;
        //切断
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        //合并
        ListNode first = new ListNode(0);
        ListNode res = first;
        while (left != null && right != null) {
            if (left.val < right.val) {
                first.next = left;
                left = left.next;
            } else {
                first.next = right;
                right = right.next;
            }
            first = first.next;
        }
        first.next = left != null ? left : right;
        return res.next;
    }
}
