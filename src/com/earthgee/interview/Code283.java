package com.earthgee.interview;

public class Code283 {

    public void moveZeroes(int[] nums) {
        int length=nums.length;
        if(length==0||length==1) return;

        int left=0;
        int right=0;
        while(right<length){
            if(nums[right]!=0) {
                swap(nums, left, right);
                left++;
            }

            right++;
        }
    }

    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    public static void main(String[] args) {
        Code283 code283=new Code283();
        code283.moveZeroes(new int[]{0,1,0,3,12});
    }

}
