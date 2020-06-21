package com.lk.leecode.code;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 */
public class Leecode14 {

    /**
     * 思路：
     *      找最大的差值
     * @param prices
     * @return
     */
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

    /**
     * 找目前状态的最小值 和最大差值值 最小值应该在前面
     * @param prices
     * @return
     */
    public int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

}
