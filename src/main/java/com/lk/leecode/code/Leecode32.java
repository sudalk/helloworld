package com.lk.leecode.code;

import java.util.ArrayList;
import java.util.List;

/**
 *组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class Leecode32 {
    /**
     *关键字：回溯 全排列 数组
     * 思路： 递归
     *        结束：
     *              小于0
     *              ==0 加入list到res
     *        循环体：（游标， 数组， 目标， 结果集）
     *
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null||candidates.length == 0||target < 0){
            return res;
        }
        for(int i=0;i<candidates.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            process(i, candidates, target-candidates[i], list);
        }
        return res;
    }

    private void process(int start,int[] candidates , int target, List<Integer> list){
        if(target<0)
            return;
        if(target == 0)
            res.add(new ArrayList<>(list));
        for(int i =start;i<candidates.length;i++){
            list.add(candidates[i]);
            process(i,candidates,target-candidates[i],list);
            list.remove(list.size() - 1);
        }
    }
}
