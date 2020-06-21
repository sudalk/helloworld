package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 21:41
 */
public class Niuke14 {

    /**
     *链表中倒数第K个数
     * 思路：
     *      双指针移动即可
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p = head;
        while(k>0){
            if(p == null){
                return null;
            }
            p=p.next;
            k--;
        }
        while(p!=null){
            p = p.next;
            head=head.next;
        }
        return head;
    }
}
