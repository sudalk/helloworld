package com.lk;

/**
 * @Author: likang
 * @Date: 2020/5/6 14:55
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
