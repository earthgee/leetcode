package com.earthgee.interview;

public class Code1143 {

    //DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
    public int longestCommonSubsequence(String text1, String text2) {
        int length1=text1.length();
        int length2=text2.length();
        int[][] dp=new int[length1+1][length2+1];

        for(int i=1;i<=length1;i++) {
            char c1=text1.charAt(i-1);
            for(int j=1;j<=length2;j++) {
                char c2=text2.charAt(j-1);
                int max = Math.max(dp[i-1][j], dp[i][j-1]);
                if(c1==c2) {
                    dp[i][j]=Math.max(dp[i-1][j-1]+1, max);
                } else {
                    dp[i][j]=max;
                }
            }
        }

        return dp[length1][length2];
    }

}
