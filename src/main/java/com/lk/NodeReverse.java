package com.lk;

/**
 * @Author: likang
 * @Date: 2020/5/6 14:55
 */
public class NodeReverse {

    /**
     * 思路：
     *      可以利用头插法
     *      head 1 2 3
     *      pre  3->2->1->null
     */
    public Node Reverse(Node head){
        Node pre = null;
        Node p = null;
        while(head!=null){
            p = head.next;
            head.next = pre;
            pre = head;
            head = p;
        }
        return pre;
    }

    public void printNodes(Node head){
        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.setNext(node2);
        node2.setNext(node3);
        NodeReverse nodeReverse = new NodeReverse();
        nodeReverse.printNodes(node1);
        Node reverse = nodeReverse.Reverse(node1);
        nodeReverse.printNodes(reverse);

    }
}
