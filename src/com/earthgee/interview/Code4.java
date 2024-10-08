package com.earthgee.interview;

public class Code4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1=nums1.length;
        int length2=nums2.length;
        int totalLength=length1+length2;

        if(totalLength % 2 ==1) {
            int middleIndex=totalLength/2;
            return getKthElement(nums1, nums2, middleIndex+1);
        } else {
            int middleIndex1=totalLength/2 - 1;
            int middleIndex2=totalLength/2;
            return (getKthElement(nums1, nums2, middleIndex1+1)
                    + getKthElement(nums1, nums2, middleIndex2+1))/2.0;
        }
    }

    //k索引从1开始 如长度是3 k=2
    private int getKthElement(int[] nums1, int[] nums2, int k){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1=0;
        int index2=0;

        while(true) {
            if(index1==length1){
                return nums2[index2+k-1];
            }

            if(index2==length2){
                return nums1[index1+k-1];
            }

            if(k==1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half=k/2;
            int newIndex1=Math.min(index1+half, length1) - 1;
            int newIndex2=Math.min(index2+half, length2) - 1;
            int pivot1=nums1[newIndex1];
            int pivot2=nums2[newIndex2];
            if(pivot1<=pivot2) {
                k-=(newIndex1-index1+1);
                index1=newIndex1+1;
            } else {
                k-=(newIndex2-index2+1);
                index2=newIndex2+1;
            }
        }
    }

}
