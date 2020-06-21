package com.lk.leecode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Leecode26 {

    /**
     *关键字：数组 回溯 递归 全排列
     * 思路：
     *      首先判断数组是否为空
     *      遍历数组，以当前点为起始    点 开始进行全排列
     *
     *      全排列：
     *          1.必须先加入一个头结点
     *          2.然后进行遍历全排列
     *          3.最后，每次遍历万都需要把最后一个节点删除，这样就不会带有重复
     */

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length == 0){
            return res;
        }
        for(int i =0;i<nums.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            process(i+1,nums,list);
        }
        res.add(new ArrayList<>());//空集
        return res;
    }

    public void process(int start, int[] nums, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            process(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}
