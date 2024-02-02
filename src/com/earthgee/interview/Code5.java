package com.earthgee.interview;

public class Code5 {

    public String longestPalindrome(String s) {
        int[][] dp=new int[s.length()][s.length()];
        int length=s.length();
        for(int i=0;i<length;i++){
            dp[i][i]=1;
        }

        for(int row=length-1;row>=0;row--){
            for(int col=row+1;col<length;col++){
                if(isReverse(s, row, col)){
                    dp[row][col]=col-row+1;
                }else{
                    dp[row][col]=Math.max(dp[row+1][col],dp[row][col-1]);
                }
            }
        }
        int max=dp[0][length-1];
        int start=0;
        int end=start+max-1;
        while(true){
            if(isReverse(s,start,end)){
                return s.substring(start, end+1);
            }
            start++;
            end++;
        }
    }

    private boolean isReverse(String s, int start, int end){
        while(start<=end){
            Character startStr=s.charAt(start);
            Character endStr=s.charAt(end);
            if(startStr!=endStr){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Code5 code5=new Code5();
        System.out.println(code5.longestPalindrome("aba"));
    }

}
