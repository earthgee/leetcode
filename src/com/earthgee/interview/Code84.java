package com.earthgee.interview;

import java.util.LinkedList;

public class Code84 {

    public int largestRectangleArea(int[] heights) {
        int length=heights.length;
        int[] left=new int[length];
        int[] right=new int[length];

        //左侧单调栈
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0;i<length;i++){
            while(!stack.isEmpty()
                && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            left[i] = (stack.isEmpty())? -1 : stack.peek();
            stack.push(i);
        }

        //右侧单调栈
        stack.clear();
        for(int i=length-1;i>=0;i--){
            while(!stack.isEmpty()
                    && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            right[i] = (stack.isEmpty())? length : stack.peek();
            stack.push(i);
        }

        int ans=0;
        for(int i=0;i<length;i++){
            ans = Math.max(ans, heights[i]*(right[i]-left[i]-1));
        }

        return ans;
    }

}
