package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code763 {

    public List<Integer> partitionLabels(String s) {
        int length=s.length();
        int[] last=new int[26];
        for(int i=0;i<length;i++) {
            last[s.charAt(i)-'a'] = i;
        }

        List<Integer> result=new ArrayList<>();
        int start = 0;
        int end=0;
        for(int i=0;i<length;i++) {
            end=Math.max(end, last[s.charAt(i)-'a']);
            if(i==end) {
                result.add(end-start+1);
                start=end+1;
            }
        }
        return result;
    }

}
