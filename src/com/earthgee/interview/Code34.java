package com.earthgee.interview;

/**
 * 二分查找标准示例
 */
public class Code34 {

    public int[] searchRange(int[] nums, int target) {
        int length=nums.length;
        if(length==0){
            return new int[]{-1,-1};
        }

        int firstIndex=findFirstTarget(nums,target);
        if(firstIndex==-1){
            return new int[]{-1,-1};
        }
        int lastIndex=findLastTarget(nums,target);
        return new int[]{firstIndex, lastIndex};
    }

    private int findFirstTarget(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            //下取整
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            } else {
                left=mid+1;
            }
        }

        if(nums[left]==target){
            return left;
        }

        return -1;
    }

    private int findLastTarget(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]<=target){
                left=mid;
            } else {
                right=mid-1;
            }
        }
        return left;
    }

}
