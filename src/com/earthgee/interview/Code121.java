package com.earthgee.interview;

public class Code121 {

    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int minPoint=Integer.MAX_VALUE;
        int length = prices.length;
        for(int index=0;index<length;index++){
            if(prices[index]<minPoint){
                minPoint=prices[index];
            }

            if(prices[index]-minPoint>max){
                max = prices[index]-minPoint;
            }
        }
        return max;
    }

}
