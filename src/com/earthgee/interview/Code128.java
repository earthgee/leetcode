package com.earthgee.interview;

import java.util.HashSet;

public class Code128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet=new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }

        int result=0;
        for(int num:numSet){
            if(numSet.contains(num-1)){
                continue;
            }

            int currentLength=0;
            int currentNum=num;
            while(numSet.contains(currentNum)){
                currentLength++;
                currentNum+=1;
            }

            if(currentLength>result){
                result=currentLength;
            }
        }
        return result;
    }

}
