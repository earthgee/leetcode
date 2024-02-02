package com.earthgee.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> hashMap=new HashMap<>();
        for(String str: strs){
            int[] count=new int[26];
            int length=str.length();

            for(int i=0;i<length;i++){
                count[str.charAt(i)-'a']++;
            }

            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<26;i++){
                if(count[i]>0){
                    stringBuilder.append((char)('a'+i));
                    stringBuilder.append(count[i]);
                }

            }

            String currentKey=stringBuilder.toString();
            List<String> value=hashMap.get(currentKey);
            if(value!=null){
                value.add(str);
            }else {
                value=new ArrayList<>();
                value.add(str);
                hashMap.put(currentKey,value);
                result.add(value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input={"bdddddddddd","bbbbbbbbbbc"};
        Code49 code49=new Code49();
        code49.groupAnagrams(input);
    }

}
