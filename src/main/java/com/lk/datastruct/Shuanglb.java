package com.lk.datastruct;

public class Shuanglb {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode p = l1;
        ListNode q = l2;
        while(p!=null&&q!=null){
            if(p.val>q.val){
                head.next=q;
                q=q.next;
                head = head.next;
            }else{
                head.next=p;
                p=p.next;
                head = head.next;
            }
        }
        while(p!=null){
            head.next= p;
            p=p.next;
            head=head.next;
        }
        while(q!=null){
            head.next= q;
            q=q.next;
            head=head.next;
        }
        return pre.next;
    }
}
