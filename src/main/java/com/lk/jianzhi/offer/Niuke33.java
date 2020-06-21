package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/2 11:34
 */
public class Niuke33 {

    /**
     * 丑数：把只包含质因子2、3和5的数称作丑数（Ugly Number）
     *
     */
    public int GetUglyNumber_Solution(int index) {

        if(index < 7){
            return index;
        }
        int p2 =0,p3 =0,p5=0;
        int arr[] = new int[index];
        arr[0] = 1;//最小的丑数
        for(int i = 1; i< index; i++){
            //每次算出最小的丑数，用最小的丑数进行计算，并移动下标
            arr[i] = Math.min(arr[p2]*2,Math.min(arr[p3]*3,arr[p5]*5));
            if(arr[i] == arr[p2]*2) p2++;
            if(arr[i] == arr[p3]*3) p3++;
            if(arr[i] == arr[p5]*5) p5++;
        }
        return arr[index-1];
    }


}
