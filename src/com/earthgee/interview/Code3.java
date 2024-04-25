package com.earthgee.interview;

import java.util.HashSet;

//最长不重复子串
public class Code3 {

    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        if(length==0 || length ==1) {
            return length;
        }

        int max=1;
        int left=0;
        int right=1;
        HashSet<Character> set=new HashSet<>();
        set.add(s.charAt(left));
        while(right<length) {
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            int currentMax=right-left+1;
            max=Math.max(currentMax,max);
            set.add(s.charAt(right));
            right++;
        }

        return max;
    }

}
