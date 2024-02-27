package com.earthgee.interview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    //最大堆
    PriorityQueue<Integer> queMin = new PriorityQueue<>((o1, o2) -> o2-o1);
    //最小堆
    PriorityQueue<Integer> queMax = new PriorityQueue<>(Comparator.comparingInt(o -> o));

    //中位数为queMin 或 (queMin+queMax)/2
    public MedianFinder() {
    }

    public void addNum(int num) {
        if(queMin.isEmpty() || num<=queMin.peek()) {
            queMin.offer(num);
            if(queMin.size() - queMax.size() > 1) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if(queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if(queMin.size() > queMax.size()) {
            return queMin.peek();
        } else {
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }

}
