package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code39 {

    private List<List<Integer>> result;
    private List<Integer> cache;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        cache=new ArrayList<>();
        int length=candidates.length;
        for(int i=0;i<length;i++){
            cache.add(candidates[i]);
            calculateInternal(candidates, target, i, candidates[i],candidates.length);
            cache.remove(Integer.valueOf(candidates[i]));
        }

        return result;
    }

    private void calculateInternal(int[] candidates, int target,
                                   int index, int curCount, int length) {
        if(curCount>=target){
            if(curCount==target){
                result.add(new ArrayList<>(cache));
            }
            return;
        }

        for(int i=index;i<length;i++){
            cache.add(candidates[i]);
            calculateInternal(candidates, target, i, curCount+candidates[i], length);
            cache.remove(Integer.valueOf(candidates[i]));
        }
    }

}
