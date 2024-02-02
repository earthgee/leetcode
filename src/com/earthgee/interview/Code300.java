package com.earthgee.interview;

public class Code300 {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int length=nums.length;
        int[] dp=new int[length];
        dp[0]=1;

        int result=1;
        for(int i=1;i<length;i++) {
            dp[i]=1;
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1, dp[i]);
                }
            }
            result= Math.max(result, dp[i]);
        }

        return result;
    }

}
