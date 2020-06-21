package com.lk.jianzhi.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: likang
 * @Date: 2020/4/23 15:38
 */
public class Niuke3 {

    /*
    输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    思路：
        递归进栈, 结束出栈
        或者直接利用栈
     */
    ArrayList<Integer> arrayList=new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<ListNode> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            list.add(node.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        ArrayList<Integer> list = new Niuke3().printListFromTailToHead(node);
        list.forEach(c-> System.out.println(c));
    }
}
