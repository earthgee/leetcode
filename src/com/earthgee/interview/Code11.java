package com.earthgee.interview;

public class Code11 {

    public int maxArea(int[] height) {
        int max=Integer.MIN_VALUE;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int leftVal=height[left];
            int rightVal=height[right];
            int minVal=Math.min(leftVal, rightVal);
            max=Math.max(max, minVal*(right-left));
            if(leftVal<=rightVal){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

}
