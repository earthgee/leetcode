package com.earthgee.interview;

import java.util.LinkedList;

public class Code42 {

    //动态规划
    public int trap(int[] height) {
        int length=height.length;
        if(length==0){
            return 0;
        }

        int[] leftMax=new int[length];
        leftMax[0]=height[0];
        for(int i=1;i<length;i++){
            leftMax[i]= Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax=new int[length];
        rightMax[length-1]=height[length-1];
        for(int i=length-2;i>=0;i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int sum=0;
        for(int i=1;i<length-1;i++){
            sum+=Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return sum;
    }

    //单调栈
    public int trap2(int[] height){
        int ans=0;
        LinkedList<Integer> stack=new LinkedList<>();
        int length=height.length;

        for(int i=0;i<length;i++){
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                int top=stack.pop();
                if(stack.isEmpty()){
                    break;
                }

                int left=stack.peek();
                int currentWidth=i-left-1;
                int currentHeight=Math.min(height[i], height[stack.peek()])-height[top];
                ans+=currentWidth*currentHeight;
            }

            stack.push(i);
        }

        return ans;
    }

    //双指针
    public int trap3(int[] height){
        int ans=0;
        int left=0;
        int length=height.length;
        int right=length-1;
        int leftMax=0;
        int rightMax=0;

        while(left<=right){
            leftMax=Math.max(leftMax, height[left]);
            rightMax=Math.max(rightMax, height[right]);
            if(height[left]<height[right]){
                ans+=Math.min(leftMax, rightMax)-height[left];
                ++left;
            }else{
                ans+=Math.min(leftMax, rightMax)-height[right];
                --right;
            }
        }

        return ans;
    }

}
