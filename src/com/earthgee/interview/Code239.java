package com.earthgee.interview;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

//滑动窗口最大值
public class Code239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length=nums.length;
        int[] result=new int[length-k+1];
        int resultLength=length-k+1;

        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair2[0]!=pair1[0]?pair2[0]-pair1[0]:pair2[1]-pair1[1];
            }
        });

        for(int i=0;i<k-1;i++){
            priorityQueue.offer(new int[]{nums[i], i});
        }

        for(int i=0;i<resultLength;i++){
            priorityQueue.offer(new int[]{nums[i+k-1], i+k-1});
            while(priorityQueue.peek()[1]<i){
                priorityQueue.poll();
            }
            result[i]=priorityQueue.peek()[0];
        }

        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int length=nums.length;
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        int[] result=new int[length-k+1];
        result[0]=nums[queue.peekFirst()];
        for(int i=k;i<length;i++){
            while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.offerLast(i);
            while(queue.peekFirst() <= i-k) {
                queue.pollFirst();
            }

            result[i-k+1]=nums[queue.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        Code239 code239=new Code239();
        int[] test={1,3,-1,-3,5,3,6,7};
        code239.maxSlidingWindow(test,3);
    }

}
