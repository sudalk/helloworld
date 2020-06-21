package com.lk.leecode.code;

/**
 * 相交链表
 *
 */
public class Leecode13 {


    /**
     *思路：
     *      关键字：链表  总数和  后面的位数一样
     *      解决：
     *           A 5  12345
     *           B 3  645
     *           A+B 5+3  123456 45
     *           B+A 3+5  645123 45
     *
     *       先判断有没有交点 尾数是不是相同
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode i = headA;
        ListNode j = headB;
        if(headA == null || headB == null){
            return null;
        }
        while(i.next!=null)  i=i.next;
        while(j.next!=null)  j=j.next;
        if(i != j) return null;
        ListNode p = headA, q = headB;
        while(p != q){
            if(p.next == null) p = headB;
            else  p = p.next;
            if(q.next == null) q = headA;
            else q = q.next;
        }
        return p;
    }
}
