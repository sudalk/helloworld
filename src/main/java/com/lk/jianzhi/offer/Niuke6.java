package com.lk.jianzhi.offer;

/**
 * @Author: likang
 * @Date: 2020/4/23 16:46
 */
public class Niuke6 {

    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    //思路：
    public int minNumberInRotateArray(int [] rotateArray) {
        if(rotateArray.length == 0)
            return 0;

        int low = 0;
        int high = rotateArray.length - 1;
        int mid = 0;

        while(low < high){
            // 子数组是非递减的数组，10111
            //当有序了之后直接返回
            if (rotateArray[low] < rotateArray[high])
                return rotateArray[low];
            mid = low + (high - low) / 2;
            //如果左边是有序的
            if(rotateArray[mid] > rotateArray[low])
                low = mid + 1;
            //如果右边是有序的
            else if(rotateArray[mid] < rotateArray[high])
                high = mid;
            //不知道，缩减范围
            else low++;
        }
        return rotateArray[low];
    }
}
