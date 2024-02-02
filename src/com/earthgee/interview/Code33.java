package com.earthgee.interview;

public class Code33 {

    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                return mid;
            }else if(mid==left){
                left=mid+1;
            }else if(mid == right){
                right=mid-1;
            }else if(nums[left]<=nums[mid-1]){
                //左有序
                if(target>=nums[left]&&target<=nums[mid-1]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                //右有序
                if(target>=nums[mid+1]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        if(nums[left]==target){
            return left;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        Code33 code33=new Code33();
        System.out.println(code33.search(nums, 0));
    }

}
