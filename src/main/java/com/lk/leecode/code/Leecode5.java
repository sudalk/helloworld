package com.lk.leecode.code;

public class Leecode5 {

    /**
     * 翻转列表
     *      头插法
     *      申请一个新的节点即可
     */
    public ListNode reverseList(ListNode head) {
        ListNode p  = new ListNode(0);
        p.next = null;
        ListNode q;
        if(head== null)
            return head;
        while(head!=null){
            q = head.next;
            head.next = p.next;
            p.next = head;
            head = q;
        }
        return p.next;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode p = head;
        ListNode q;
        if(head == null ){
            return head;
        }
        head = head.next;
        p.next=null;
        while(head != null){
            q = head.next;
            head.next = p.next;
            p.next = head;
            head = q;
        }
        return p;
    }
}
