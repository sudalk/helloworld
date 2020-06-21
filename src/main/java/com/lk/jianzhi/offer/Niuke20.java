package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/28 16:04
 */
public class Niuke20 {


    /**
     *给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     *1.首先判断是否有没有环
     *2.利用公式去计算链表是否有环
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if(!canCycle(pHead)){
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = pHead;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public boolean canCycle(ListNode pHead){
        ListNode slow = pHead;
        ListNode fast = pHead;
        if(pHead.next == null){
            return false;
        }
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
