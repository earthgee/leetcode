package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code46 {

    static List<Integer> once=new ArrayList<>();

    static int num=0;

    public List<List<Integer>> permute(int[] nums) {
        num=0;
        once.clear();
        result.clear();
        int length = nums.length;
        boolean[] mask=new boolean[length];
        for(int i=0;i<length;i++){
            nested(nums, mask, i, length);
        }
        return result;
    }

    private void nested(int[] nums,boolean[] mask,int index, int length) {
        mask[index]=true;
        once.add(Integer.valueOf(nums[index]));
        num++;

        if(num==length){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<length;i++){
                temp.add(once.get(i));
            }
            result.add(temp);
            mask[index]=false;
            once.remove(Integer.valueOf(nums[index]));
            num--;
            return;
        }

        for(int i=0;i<length;i++){
            if(!mask[i]){
                nested(nums, mask, i, length);
            }
        }
        mask[index]=false;
        once.remove(Integer.valueOf(nums[index]));
        num--;
    }

    public static void main(String[] args) {
        int[] nums={0,1};
        Code46 code=new Code46();
        code.permute(nums);
//        System.out.println(result);
    }

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> permute2(int[] nums) {
        List<Integer> output = new ArrayList<>();
        int length=nums.length;

        boolean[] mask = new boolean[length];
        backtrace(nums, output, mask, length);
        return result;
    }

    private void backtrace(int[] nums, List<Integer> output, boolean[] mask, int length) {
        if(output.size() == length) {
            result.add(new ArrayList<>(output));
            return;
        }

        for(int i=0;i<length;i++) {
            if(!mask[i]) {
                output.add(nums[i]);
                mask[i] = true;

                backtrace(nums, output, mask, length);

                output.remove(Integer.valueOf(nums[i]));
                mask[i] = false;
            }
        }

    }

}
