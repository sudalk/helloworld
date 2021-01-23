//package com;
//
//import org.thymeleaf.expression.Lists;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @Author: likang
// * @Date: 2020/11/17 20:01
// */
//public class Test1 {
//
//    //字符串hshaksdhqqkqwkasfa,shgjqijasjkdhajkcsnidh取出所有相邻a和s之间的字符串并排序
//    //思路：暴力遍历操作，先匹配a,然后匹配s, 然后a指向s的下一个位置；第二种方式就是正则表达式
//    public static void getStringA2S(String s) {
//        char[] array = s.toCharArray();
//        List<String> list = new ArrayList<>();
//        StringBuffer buffer = new StringBuffer();
//        int length = array.length;
//        int i = 0;
//        while (i < length) {
//            if (array[i] == 'a') {
//                int j;
//                for (j = i + 1; j < length; j++) {
//                    if (array[j] == 's') {
//                        break;
//                    }
//                    buffer.append(array[j]);
//                }
//                if (j >= length) {
//                    break;
//                }
//                if(j != i+1) {
//                    list.add(buffer.toString());
//                }
//                buffer.setLength(0);
//                i=j;
//            }else{
//                i++;
//            }
//        }
//        Collections.sort(list);
//        System.out.println(Arrays.toString(list.toArray()));
//    }
//
//    /**
//     * 假设有100个任务的id,通过id为入参执行业务代码；
//     * 利用主线程，对100个任务按批次数目进行分片
//     * 然后在主线程中，对批次任务顺序调用
//     */
//    public void tasks(List<String> allTaskIDs, int num){
//        //进行分片，形成批次任务
//        List<List<String>> lists=Lists.partition(allTaskIDs, num);
//        for(List<String> list :lists){
//            //根据id，查找具体任务，并进行执行
//            execute(list);
//        }
//    }
//
//    public void execute(List<String> taskIDs){
//        System.out.println("执行当前批次任务："+Arrays.toString(taskIDs.toArray()));
//        for(String task:taskIDs) {
//            System.out.println("执行当前批次"+task+"任务..........................");
//        }
//    }
//
//    public static void main(String[] args) {
//        getStringA2S("hshaksdhqqkqwkasfa,shgjqijasjkdhajkcsnidh");
//    }
//}
