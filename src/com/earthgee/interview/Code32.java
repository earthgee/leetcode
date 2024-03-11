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
                } else if(i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    if(i-dp[i-1]>=2) {
                        dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2;
                    } else {
                        dp[i] = dp[i-1] + 2;
                    }
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        Code32 code32=new Code32();
        System.out.println(code32.longestValidParentheses("(()())"));
    }

}
