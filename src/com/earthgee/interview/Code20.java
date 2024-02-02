package com.earthgee.interview;

import java.util.LinkedList;

public class Code20 {

    public boolean isValid(String s) {
        LinkedList<Character> stack=new LinkedList<>();
        int length=s.length();
        for(int i=0;i<length;i++){
            char ch=s.charAt(i);
            if(ch =='('||ch=='['||ch=='{'){
                stack.push(ch);
            }else {
                if(stack.isEmpty()) return false;
                char chOther=stack.pop();
                if(ch==')' && chOther!='('){
                    return false;
                }
                if(ch==']'&&chOther!='['){
                    return false;
                }
                if(ch=='}'&&chOther!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
