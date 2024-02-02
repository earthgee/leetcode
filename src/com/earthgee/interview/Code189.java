package com.earthgee.interview;

public class Code189 {

    public void rotate(int[] nums, int k) {
        int length=nums.length;
        int exchNum=0;
        k = k%length;

        int currentIndex;
        int prev;
        int i;
        boolean exchEnd=false;
        for(i=0;i<length;i++){
            currentIndex=i;
            prev=nums[i];
            do {
                int next=(currentIndex+k)%length;
                int tmp=nums[next];
                nums[next]=prev;
                currentIndex=next;
                prev=tmp;
                exchNum++;
                if(exchNum==length){
                    exchEnd=true;
                    break;
                }
            }while(i!=currentIndex);
            if(exchEnd){
                break;
            }
        }
    }

}
