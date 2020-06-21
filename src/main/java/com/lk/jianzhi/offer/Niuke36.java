package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/2 16:20
 */
public class Niuke36 {

    /**
     *
     */
    private int count;
    public int InversePairs(int [] array) {
        megerSort(array, 0 , array.length-1);
        return count;
    }

    /**
     * 归并排序
     */
    public void megerSort(int [] array, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        megerSort(array, start, mid);
        megerSort(array, mid+1, end);
        meger(array, start, mid, end);
    }
    public void meger(int[] array, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int k = 0, i = start, j = mid+1;
        while(i<=mid && j<=end){
            if(array[i] <= array[j]) {
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
                //如果当前的值大于  3-1+1
                //1 5 6 7
                //2 3 8
                count = (count+(mid - i+1))%1000000007;
            }
        }
        //结束之后
        while(i<=mid) temp[k++] = array[i++];
        while(j<=end) temp[k++] = array[j++];
        //赋值
        for(int m = 0; m < k; m++){
            array[start+m] = temp[m];
        }
    }
}
