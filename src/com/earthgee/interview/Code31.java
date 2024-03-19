package com.earthgee.interview;

import java.util.Arrays;

public class Code31 {

    public void nextPermutation(int[] nums) {
        int length=nums.length;
        if(length==1) {
            return;
        }

        int indexLeft = -1;
        for(int i=length;i>=2;i--){
            if(nums[i-2]<nums[i-1]) {
                indexLeft = i-2;
                break;
            }
        }

        int indexRight = -1;
        if(indexLeft!=-1) {
            for(int i=length-1;i>indexLeft;i--) {
                if(nums[i]>nums[indexLeft]) {
                    indexRight = i;
                    break;
                }
            }
        }

        if(indexLeft!=-1) {
            int tmp=nums[indexLeft];
            nums[indexLeft]=nums[indexRight];
            nums[indexRight]=tmp;
        }

        int left=indexLeft+1;
        int right=length-1;
        while(left<right){
            int tmp=nums[left];
            nums[left]=nums[right];
            nums[right]=tmp;
            left++;right--;
        }

    }

    public static void main(String[] args) {
        Code31 code31=new Code31();
        int[] array = new int[]{3,2,1};
        code31.nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

}
