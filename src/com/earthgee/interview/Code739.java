package com.earthgee.interview;

import java.util.LinkedList;

public class Code739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int length=temperatures.length;
        LinkedList<Integer> stack=new LinkedList<>();
        int[] ans=new int[length];

        for(int i=0;i<length;i++){
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > temperatures[stack.peek()]){
                int index=stack.pop();
                ans[index]=i-index;
            }
            stack.push(i);
        }

        return ans;
    }

}
