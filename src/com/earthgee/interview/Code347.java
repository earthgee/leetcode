package com.earthgee.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Code347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i, map.get(i)==null?1:map.get(i)+1);
        }

        //小根堆
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num=entry.getKey();
            int count=entry.getValue();
            if(queue.size()==k){
                if(queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }else{
                queue.offer(new int[]{num, count});
            }
        }

        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=queue.poll()[0];
        }
        return result;
    }

}
