package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 22:50
 */
public class Niuke16 {

    /**
     * 链表的合并
     */
    public ListNode Merge(ListNode l1,ListNode l4) {
        ListNode p=null,q=null,h=null;
        if(l1==null&&l4!=null)
            return l4;
        if(l1!=null&&l4==null)
            return l1;
        if(l1==null&&l4==null)
            return null;

        if(l1.val>l4.val){
            p=l4;
            l4=l4.next;
        }
        else{
            p=l1;
            l1=l1.next;
        }
        h=p;
        while(l1!=null&&l4!=null){
            if(l1.val>l4.val){
                q=l4;
                l4=l4.next;
                p.next=q;
                p=q;
            }
            else{
                q=l1;
                l1=l1.next;
                p.next=q;
                p=q;
            }
        }
        if(l1==null){
            p.next=l4;
        }
        else if(l4==null){
            p.next=l1;

        }
        return h;
    }
}
