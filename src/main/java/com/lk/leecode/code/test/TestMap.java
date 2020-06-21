package com.lk.leecode.code.test;

import com.lk.datastruct.ListNode;

import java.util.*;

public class TestMap {

    public static void main(String[] args) {
        TreeMap Tree = new TreeMap();
    }

//    public ListNode EntryNodeOfLoop(ListNode pHead)
//    {
//        if(pHead == null) return null;
//        if (isLoop(pHead)){
//            ListNode slow = pHead.next;
//            ListNode fast = pHead.next.next;
//
//            while(slow != fast){
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            // 循环结束时候  slow == fast
//            slow = pHead;
//            // 一个从头开始走 ，一个从相遇地方开始走，走同样的步数
//            // 因为 x= z+(n-1)L
//            while(slow != fast){
//                slow = slow.next;
//                fast = fast.next;
//            }
//            return slow;
//        }
//        else  return null;
//    }
//
//    public boolean isLoop(ListNode pHead){
//        if (pHead.next == null) return false;
//        ListNode slow = pHead;
//        ListNode fast = pHead;
//        while (fast != null && fast.next !=null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast){
//                return true;
//            }
//        }
//        return false;
//    }
}
