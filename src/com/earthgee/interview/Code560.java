package com.earthgee.interview;

import java.util.HashMap;

public class Code560 {

    public int subarraySum(int[] nums, int k) {
        int length=nums.length;
        int result=0;
        for(int index=0;index<length;index++){
            int sum=0;
            for(int j=index;j>=0;j--){
                sum+=nums[j];
                if(sum==k){
                    result++;
                }
            }
        }
        return result;
    }

    //前缀和+HashMap
    public int subarraySum2(int[] nums, int k) {
        int length=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        int result=0;
        map.put(0,1);
        int pre=0;
        for(int index=0;index<length;index++){
            pre=pre+nums[index];
            if(map.containsKey(pre-k)){
                result += map.get(pre-k);
            }

            if(map.containsKey(pre)){
                map.put(pre, map.get(pre)+1);
            } else {
                map.put(pre, 1);
            }
        }

        return result;
    }

}
