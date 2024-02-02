package com.earthgee.interview;

public class Code35 {

    //在一个有序数组中找第一个大于等于 target 的下标
    public int searchInsert(int[] nums, int target) {
        int length=nums.length;
        int left=0,right=length-1,ans=length;
        while (left<=right){
            int mid = ((right - left) >> 1) + left;
            if(target<=nums[right]){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
