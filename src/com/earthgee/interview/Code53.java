package com.earthgee.interview;

public class Code53 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int preMax = 0;
        for(int num: nums) {
            preMax = Math.max(preMax + num, num);
            max = Math.max(max, preMax);
        }

        return max;
    }

}
