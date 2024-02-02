package com.earthgee.interview;

public class Code152 {

    public int maxProduct(int[] nums) {
        int length=nums.length;
        int[] dpMax=new int[length];
        int[] dpMin=new int[length];

        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        int result=nums[0];
        for(int i=1;i<length;i++){
            dpMax[i]=Math.max(dpMax[i-1]*nums[i], Math.max(dpMin[i-1]*nums[i], nums[i]));
            dpMin[i]=Math.min(dpMax[i-1]*nums[i], Math.min(dpMin[i-1]*nums[i], nums[i]));
            result=Math.max(dpMax[i], result);
        }

        return result;
    }

}
