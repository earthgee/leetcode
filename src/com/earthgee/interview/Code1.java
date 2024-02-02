package com.earthgee.interview;

import java.util.HashMap;

public class Code1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(nums[0],0);
        for(int i=1;i<length;i++){
            int find = target-nums[i];
            if(map.containsKey(find)){
                result[0]=i;
                result[1]=map.get(find);
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }

}
