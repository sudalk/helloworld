package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 22:50
 */
public class Niuke15 {

    /**
     * 翻转列表
     */
    public ListNode ReverseList(ListNode head) {
        ListNode q=null,l=null;
        while(head!=null){
            q=head;
            head=head.next;
            q.next=l;
            l=q;
        }
        return l;

    }
}
