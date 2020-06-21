package com.lk.leecode.code;

/**
 * 迷宫
 * 关键字：回溯 递归
 * 思路：
 *      前后左右
 */
public class Leecode37migong {
    private int[][] array = {
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 1, 0, 1},
            {0, 1, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0}

    };
    private int maxLine = 8;
    private int maxRow = 9;

    public void search(int i, int j){
        //递归结束条件
        if (i == maxRow - 1 && j == maxLine - 1) {
            print();
            return;
        }
        //i-1 上
        if(check(i,j,i-1,j)){
            array[i][j] = 5;
                search(i - 1, j);
            array[i][j] = 0;
        }

        //i+1 下
        if(check(i,j,i+1,j)){
            array[i][j] = 5;
            search(i+1,j);
            array[i][j] = 0;
        }

        //j-1 左
        if(check(i,j,i,j-1)){
            array[i][j] = 5;
            search(i,j-1);
            array[i][j] = 0;
        }

        //j+1 右
        if(check(i,j,i,j+1)){
            array[i][j] = 5;
            search(i,j+1);
            array[i][j] = 0;
        }

    }

    private boolean check(int i, int j, int targetI, int targetJ){
        if (targetI < 0 || targetJ < 0 || targetI >= maxRow || targetJ >= maxLine) {
//            System.out.println("到达最左边或最右边，失败了");
            return false;
        }
        if (array[targetI][targetJ] == 1) {
//            System.out.println("目标是墙，失败了");
            return false;
        }
        //避免在两个空格间来回走
        if (array[targetI][targetJ] == 5) {
//            System.out.println("来回走，失败了");
            return false;
        }

        return true;
    }

    private void print() {
        System.out.println("得到一个解：");
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxLine; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        new Leecode37migong().search(0, 0);

    }
 }
