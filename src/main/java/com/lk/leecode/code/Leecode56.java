package com.lk.leecode.code;

/**
 * @Author: likang
 * @Date: 2020/4/12 16:31
 */
public class Leecode56 {


    /**
     * 简单思路回溯算法
     */



    /**
     *可达性分析
     * 倒着走，每个节点我们检查是否存在一步跳跃可以到达 GOOD 的位置
     * Index0	1	2	3	4	5	6
     * nums	9	4	2	1	0	2	0
     * memo	U	G	B	B	B	G	G
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for(int i = nums.length-1; i >= 0; i--){
            if(i+nums[i]>=last){
                last = i;
            }
        }
        if(last == 0) return true;
        return false;
    }

    //另外的一种，从前到后
    //对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
    //如果再跳的过程中，当前格子比后面的最远距离大，就gameover
    public boolean canJump1(int[] nums) {
        int maxPos = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(i > maxPos){
                return false;
            }
            maxPos = Math.max(maxPos ,nums[i]+i);
        }
        return true;
    }

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump3(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

}
