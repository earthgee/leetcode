package com.earthgee.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Code56 {

    public int[][] merge(int[][] intervals) {
        int length= intervals.length;
//        Arrays.sort(intervals);

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        ArrayList<int[]> result=new ArrayList<>();

        for(int i=0;i<length;i++){
            int[] current=intervals[i];
            if(result.isEmpty()){
                result.add(current);
            } else {
                int[] last=result.get(result.size()-1);
                if(current[0]<=last[1]){
                    //mix
                    last[1]=Math.max(last[1], current[1]);
                }else{
                    result.add(current);
                }
            }
        }

        int resultSize= result.size();
        int[][] resultArray=new int[result.size()][2];
        for(int i=0;i<resultSize;i++){
            resultArray[i]=result.get(i);
        }
        return resultArray;
    }

}
