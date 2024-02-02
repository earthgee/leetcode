package com.earthgee.interview;

public class Code55 {

    public boolean canJump(int[] nums) {
        int end=nums.length;
        int max=0;
        for(int i=0;i<end;i++){
            if(i<=max){
                max=Math.max(max, i+nums[i]);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code55 code55=new Code55();
        int[] test={2,3,1,1,4};
        code55.canJump(test);
    }

}
