package com.earthgee.interview;

public class Code72 {

    public int minDistance(String word1, String word2) {
        int length1=word1.length();
        int length2=word2.length();

        if(length1 == 0) {
            return length2;
        }
        if(length2 == 0) {
            return length1;
        }

        int[][] dp=new int[length1+1][length2+1];
        for(int i=0;i<=length1;i++) {
            dp[i][0]=i;
        }
        for(int j=0;j<=length2;j++) {
            dp[0][j]=j;
        }

        for(int i=1;i<=length1;i++) {
            for(int j=1;j<=length2;j++) {
                char ch1=word1.charAt(i-1);
                char ch2=word2.charAt(j-1);
                if(ch1 == ch2) {
                    dp[i][j]=Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]));
                } else {
                    dp[i][j]=Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));
                }
            }
        }

        return dp[length1][length2];
    }

}
