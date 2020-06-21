package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/5/1 13:06
 */
public class Niuke23 {

    /**
     * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        //进入遍历的过程
        return isBST(sequence, 0, sequence.length-1);
    }

    private boolean isBST(int[] seq, int start, int end) {
        //递归的出口
        if(start >= end){
            return true;
        }
        //最后为根节点
        int root = seq[end];
        int mid = start;
        //找到第一个大于根节点的值
        while(mid<end && seq[mid]<root){
            mid++;
        }
        //判断右子树是否存在小于根节点的值
        for(int i = mid; i<end; i++){
            if(seq[i]<root){
                return false;
            }
        }
        return isBST(seq, start, mid-1)&&isBST(seq, mid,end-1);
    }
}
