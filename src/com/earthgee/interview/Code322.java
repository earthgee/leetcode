package com.earthgee.interview;

import java.util.Arrays;

public class Code322 {

    public int coinChange(int[] coins, int amount) {
        if(amount<1){
            return 0;
        }

        int max=amount+1;
        int[] dp=new int[amount+1];
        Arrays.fill(dp, max);
        dp[0]=0;
        int length=coins.length;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<length;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount]==max){
            return -1;
        }else{
            return dp[amount];
        }
    }

}
