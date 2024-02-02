package com.earthgee.interview;

public class Code215 {

    //构建大根堆做K次删除
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i=nums.length-1;i>=nums.length-k+1;i--){
            swap(nums,0,i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for(int i=heapSize/2;i>=0;i--){
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int index, int heapSize) {
        int leftChild = 2*index +1;
        int rightChild = 2*index +2;
        int largest = index;
        if(leftChild < heapSize && nums[leftChild] > nums[largest]){
            largest = leftChild;
        }
        if(rightChild < heapSize && nums[rightChild] > nums[largest]){
            largest = rightChild;
        }
        if(largest != index) {
            swap(nums, index, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
