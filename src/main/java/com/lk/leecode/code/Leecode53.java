package com.lk.leecode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: likang
 * @Date: 2020/4/6 21:29
 */
public class Leecode53 {

    List<List<String>> ress = new ArrayList<>();
    private int[] res;

    public void eightQueens(int row, int n){
        if(row == n){
            addResult(res,n);
        }

        for(int column =0;column<n;column++){
            //如果满足皇后不会相互攻击的条件
            if(isOk(row,column,n)){
                res[row] = column;
                //继续寻找当前条件下的下一行
                eightQueens(row+1,n);
            }
        }
    }

    //每一次都比较三个值
    /*
       三个变量进行移动
       4   1   5
         2 1 3（这个开始）
           1
     */
    public boolean isOk(int row, int column, int n){
        int left = column -1;
        int right = column +1;
        for(int i = row -1;i>=0;i--){
            //判断中间
            if(res[i] == column){
                return false;
            }
            //判断左对角线
            if(left >= 0){
                if(res[i] == left) return false;
            }
            //判断右对角线
            if(right < n){
                if(res[i] == right) return false;
            }
            //对角线移动
            --left;++right;
        }
        return true;
    }
    public void addResult(int[] result,int n) { // 打印出一个二维矩阵
        List<String> rowStringList = new ArrayList<>();
        for (int row = 0; row < n; ++row) {
            StringBuilder sb = new StringBuilder();
            for (int column = 0; column < n; ++column) {
                if(result[row] == column){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            rowStringList.add(sb.toString());
        }
        ress.add(rowStringList);
    }

    public List<List<String>> solveNQueens(int n) {
        res = new int[n];
        eightQueens(0, n);
        return ress;
    }
}
