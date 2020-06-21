package com.lk.offer;

/**
 * @Author: likang
 * @Date: 2020/4/10 13:57
 */
public class ThreadOffer {

    private static Object object = new Object();

    public static void main(String[] args) {
        int []a = {1,2,3};
        char []b = {'a','b','c'};
        new Thread(()->{
            for(int i=0;i<3;i++){
                synchronized (object){
                    System.out.print(a[i]);
                    object.notify();
                    try {
                        if(i<2) {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(()->{
            for(int i=0;i<3;i++){
                synchronized (object){
                    System.out.println(b[i]);
                    object.notify();
                    try {
                        if(i<2) {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
