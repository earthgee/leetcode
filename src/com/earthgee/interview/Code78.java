package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code78 {

    List<List<Integer>> result;
    List<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int length=nums.length;
        for(int i=0;i<length;i++){
            list=new ArrayList<>();
            nested(nums,i,length);
        }
        List<Integer> empty=new ArrayList<>();
        result.add(empty);
        return result;
    }

    private void nested(int[] nums,int index,int length){
        if(index==length){
            return;
        }

        list.add(nums[index]);

        List<Integer> current=new ArrayList<>();
        for(Integer integer:list){
            current.add(integer);
        }
        result.add(current);

        for(int i=index+1;i<=length;i++){
            nested(nums, i, length);
            if(i<length){
                list.remove(Integer.valueOf(nums[i]));
            }
        }
    }

    public static void main(String[] args) {
        Code78 code78=new Code78();
        int[] test={1,2,3,4};
        System.out.println(code78.subsets(test));
    }

}
