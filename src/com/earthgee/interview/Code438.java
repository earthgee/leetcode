package com.earthgee.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Code438 {

    public List<Integer> findAnagrams(String s, String p) {
        int length=s.length();
        int pLength=p.length();
        if(length<pLength){
            return new ArrayList<>();
        }

        List<Integer> result=new ArrayList<>();
        int[] sCount=new int[26];
        int[] pCount=new int[26];
        for(int i=0;i<pLength;i++){
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        for(int i=0;i<length-pLength;i++){
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+pLength)-'a']++;

            if(Arrays.equals(sCount, pCount)){
                result.add(i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Code438 code438=new Code438();
        code438.findAnagrams("cbaebabacd", "abc");
    }

}
