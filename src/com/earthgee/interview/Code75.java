package com.earthgee.interview;

public class Code75 {

    public void sortColors(int[] nums) {
        int length=nums.length;
        int left=0;
        int right=1;
        while(right<length){
            if(nums[left]==0){
                left++;
                right++;
            }else if(nums[right]==0){
                int tmp=nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                left++;
                right++;
            }else{
                right++;
            }
        }

        if(left<length){
            right=left+1;
            while(right<length){
                if(nums[left]==1){
                    left++;
                    right++;
                }else if(nums[right]==1){
                    int tmp=nums[left];
                    nums[left]=nums[right];
                    nums[right]=tmp;
                    left++;
                    right++;
                }else{
                    right++;
                }
            }
        }
    }

}
