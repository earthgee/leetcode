package com.earthgee.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int length=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<length;i++){
            if(i==0 || nums[i] != nums[i-1]){
                int target=-nums[i];
                int k=length-1;

                for(int j=i+1;j<length;j++){
                    if(j>i+1 && nums[j]==nums[j-1]){
                        continue;
                    }

                    while(j<k && nums[j]+nums[k]>target){
                        k--;
                    }

                    if(j==k){
                        break;
                    }

                    if(nums[j]+nums[k]==target){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }

        return result;
    }

}
