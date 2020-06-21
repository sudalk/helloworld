package com.lk.leecode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Leecode27 {

    /**
     *关键字：回溯 全排列 数组
     * 思路： 递归
     *        结束：结果长度为n，加入一个新的list
     *        循环体；添加
     *              不可以包含已有的节点
     *        剪枝
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length == 0){
            return res;
        }
        int n = nums.length;
        for(int i =0;i<nums.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            process(n,nums,list);
        }
        return res;
    }

    public void process(int n, int[] nums, List<Integer> list){
       if(list.size() == n){
           res.add(new ArrayList<>(list));
           return;
       }
       for(int i=0;i<n ;i++){
           if(!list.contains(nums[i])){
               list.add(nums[i]);
               process(n,nums,list);
               list.remove(list.size()-1);
           }
       }
    }
}
