package com.lk.datastruct;

public class DaoshuK {
/*
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        ListNode q = pre;
        while(q.next!=null&&n>0){
            q=q.next;
            --n;
        }
        //一起移动
        while(q.next!=null){
            q=q.next;
            p=p.next;
        }
        //删除节点p
        p.next = p.next.next;
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);

        ListNode h = new ListNode(1); head.next = h;
        new DaoshuK().removeNthFromEnd(head, 1);
    }
}
