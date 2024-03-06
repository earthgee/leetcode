package com.earthgee.interview;

public class Code32 {

    public int longestValidParentheses(String s) {
        int maxAns = 0;
        int length=s.length();
        int[] dp = new int[length];
        for(int i=1;i<length;i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    dp[i] = (i>=2? dp[i-2]:0) +2;
                } else if(i-dp[i-1]-1 > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2;
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

}
