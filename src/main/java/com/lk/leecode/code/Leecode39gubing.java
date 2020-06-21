package com.lk.leecode.code;

/**
 * 归并排序
 */
public class Leecode39gubing {
/**
 * 思路：递归
 */

    public void mergeSort(int[] nums, int left, int right){
        //递归结束
        if(left == right){
            return;
        }
        //找中心
        int mid = left + ((right - left)>>1);
        //递归调用
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        //合并
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right){
        //申请临时空间
        int[] temp = new int[right-left+1];
        //下标移动对比
        int i =0, p1 = left, p2 = mid+1;
        while(p1<=mid&&p2<=right){
            temp[i++] = nums[p1]<nums[p2]?nums[p1++]:nums[p2++];
        }
        while(p1<=mid){
            temp[i++] = nums[p1++];
        }
        while(p2<=mid){
            temp[i++] = nums[p2++];
        }
        //临时数组转移
        for(i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}
