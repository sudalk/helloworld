package com.lk.datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sanshu {

    /*
    思路，数组 +双指针

     */
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        int n = a.length;
        if(a == null || n<3) return res;
        //排序
        Arrays.sort(a);
        //遍历，从头开始，如果大于0，直接返回，然后设置左右指针
        for(int i =0;i<n;i++){
            if(a[i] > 0 ) return res;
            if(i>0&&a[i]==a[i-1]){
                continue;
            }
            int L = i+1;int R = n-1;
            while(L<R){
                int sum = a[i]+a[L]+a[R];
                if(sum == 0){
                    res.add(Arrays.asList(a[i],a[L],a[R]));
                    while(L<R&&a[L]==a[L+1]) L++;
                    while(L<R&&a[R]==a[R-1]) R--;
                    ++L;
                    --R;
                }else if(sum>0) --R;
                else ++L;
            }
        }
        return res;
    }
}
