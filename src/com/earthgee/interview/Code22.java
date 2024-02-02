package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code22 {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        generateInternal(n*2, 0, 0, 0, "");
        return result;
    }

    private void generateInternal(int n, int length, int left, int right, String str){
        if((length == n) && (left == right)) {
            result.add(str);
            return;
        }

        if(left+1<=n/2){
            generateInternal(n, length+1, left+1, right, str+"(");
        }
        if(right+1<=left){
            generateInternal(n, length+1, left, right+1, str+")");
        }
    }

    public static void main(String[] args) {
        Code22 code22=new Code22();
        code22.generateParenthesis(1);
    }

}
