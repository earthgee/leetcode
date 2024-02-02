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

    private int getKthElement(int[] nums1, int[] nums2, int k){
        int length1=nu
    }

}
