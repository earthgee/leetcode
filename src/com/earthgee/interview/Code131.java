package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code131 {

    private List<List<String>> result=new ArrayList<>();

    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0){
            return new ArrayList<>();
        }

        search(s, 0, s.length(), new ArrayList<String>());
        return result;
    }

    private void search(String s, int index, int length, ArrayList<String> list) {
        if(index==length){
            ArrayList<String> shotResult=new ArrayList<>();
            shotResult.addAll(list);
            result.add(shotResult);
            return;
        }

        for(int i=index;i<length;i++){
            boolean isCycle=isCycle(s, index, i);
            if(!isCycle) {
                continue;
            }

            list.add(s.substring(index, i+1));
            search(s, i+1, length, list);
            list.remove(list.size()-1);
        }
    }

    private boolean isCycle(String s, int left, int right){
        while(left<=right){
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);
            if(leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
