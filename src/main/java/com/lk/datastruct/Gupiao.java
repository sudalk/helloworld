package com.lk.datastruct;

/*
还有一种思路就是：
每一次比较，都是先比较当前值，如果大于当前值，在比较当前值与之前的差值是否大于最大差
 */
public class Gupiao {

    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i =0;i<prices.length-1;i++){
            int sum =0;
            for(int j=i+1;j<prices.length;j++){
                int ins = 0;
                if(prices[i]<prices[j]){
                    ins = prices[j] - prices[i];
                }
                sum = Math.max(sum, ins);
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
