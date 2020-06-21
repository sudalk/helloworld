package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 14:40
 */
public class Niuke1 {

    /*
    在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

    思路：
        从每一行的尾部开始遍历，如果大于尾部，就说明该值在下面，如果小于，就在这一行
     */
    public boolean Find(int target, int [][] array) {
        int column = array[0].length-1;
        int row = 0;
        int rowLength = array.length;
        while(row < rowLength && column >= 0){
            if(array[row][column] > target){
                //当前行，前面一列
                column--;
            }else if(array[row][column] < target){
                //下一行
                row++;
            }else{
                return true;
            }
        }
        return false;
    }

}
