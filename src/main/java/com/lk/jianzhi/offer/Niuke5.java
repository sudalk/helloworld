package com.lk.jianzhi.offer;

import java.util.Stack;

/**
 * @Author: likang
 * @Date: 2020/4/23 16:33
 */

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Niuke5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /*
    进栈：直接进第一个栈
     */
    public void push(int node) {
        stack1.push(node);
    }
    /*
    出栈：若第二个栈不为空，直接出栈
          否则，把栈1的进栈二，然后再出栈
     */
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
