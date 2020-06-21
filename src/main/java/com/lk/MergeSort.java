package com.lk;

/**
 * @Author: likang
 * @Date: 2020/5/6 16:46
 */
public class MergeSort {

    /**
     * 思路：归并排序的merge操作
     * @param a
     * @param b
     * @return
     */
    public int[] merge(int[] a, int[] b){
        int m = a.length, n = b.length;
        int[] c = new int[m+n];
        int i =0, j =0, k =0;
        while(i<m && j<n){
            if(a[i] <= b[j]){
                c[k++] = a[i++];
            }else{
                c[k++] = b[j++];
            }
        }
        if(i<m){
            while(i<m){
                c[k++] = a[i++];
            }
        }
        if(j<n){
            while(j<n){
                c[k++] = b[j++];
            }
        }
        return c;
    }
    public void Print(int[] nums){
        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println("");
    }

    /**
     * 123
     * 456
     * 789
     * 思路：
     * pool:{1 4 7},   1  {2,4,7}  O(n*k)  logk
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] a = {1,3,5,8};
        int[] b = {2,3,6,7,9,10};
        MergeSort mergeSort = new MergeSort();
        int[] merge = mergeSort.merge(a, b);
        mergeSort.Print(a);
        mergeSort.Print(b);
        mergeSort.Print(merge);
    }
}
