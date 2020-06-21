package com.lk.jianzhi.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: likang
 * @Date: 2020/4/23 21:41
 */
public class Niuke13 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    //思路：还是乖乖利用队列，空间和时间复杂度均为O(n)
    public void reOrderArray(int [] array) {
        if(array == null || array.length ==0){
            return;
        }
        Queue<Integer> oddQueue = new LinkedList<>();
        Queue<Integer> evenQueue = new LinkedList<>();
        for(int num : array){
            if(isOdd(num)){
                oddQueue.offer(num);
            } else{
                evenQueue.offer(num);
            }
        }
        int i = 0;
        while(!oddQueue.isEmpty()){
            array[i++] = oddQueue.poll();
        }
        while(!evenQueue.isEmpty()){
            array[i++] = evenQueue.poll();
        }
    }
    public boolean isOdd(int number){
        if((number&1)==1){
            return true;
        }
        return false;
    }


}
