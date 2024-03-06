package com.earthgee.interview;

public class Code416 {

    public boolean canPartition(int[] nums) {
        int length=nums.length;
        if(length<2) {
            return false;
        }

        int sum = 0;
        int maxNum = 0;
        for(int i:nums) {
            sum+=i;
            maxNum=Math.max(maxNum, i);
        }

        if(sum%2!=0) {
            return false;
        }
        int target=sum/2;
        if(maxNum>target) {
            return false;
        }

        //dp[i][j] 表示从数组的 [0,i]下标范围内选取若干个正整数（可以是 0 个），
        // 是否存在一种选取方案使得被选取的正整数的和等于 j。
        boolean[][] dp=new boolean[length][target+1];
        for(int i=0;i<length;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;

        for(int i=1;i<length;i++) {
            int num=nums[i];
            for(int j=1;j<=target;j++) {
                if(j>=num) {
                    dp[i][j]=dp[i-1][j]|dp[i-1][j-num];
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[length-1][target];
    }

}
