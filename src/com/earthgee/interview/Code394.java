package com.earthgee.interview;

import java.util.LinkedList;

public class Code394 {

    LinkedList<Integer> stack;
    LinkedList<StringBuilder> strStack;
    StringBuilder result;

    public String decodeString(String s) {
        stack=new LinkedList<>();
        result=new StringBuilder();
        strStack=new LinkedList<>();
        strStack.push(result);
        int length=s.length();

        int currentNum=0;
        for(int i=0;i<length;){
            Character ch=s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                Pair pair=getNum(s,i);
                currentNum=pair.num;
                i=pair.index;
            } else if(ch == '[') {
                stack.push(currentNum);
                strStack.push(new StringBuilder());
                i++;
            } else if(ch == ']') {
                String append = strStack.pop().toString();
                int time=stack.pop();
                System.out.println("time="+time+",str="+append);
                for(int index=0;index<time;index++){
                    strStack.peek().append(append);
                }
                i++;
            } else {
                strStack.peek().append(ch);
                i++;
            }
        }

        return strStack.pop().toString();
    }

    private Pair getNum(String s,int index){
        int length=s.length();
        int num=0;
        for(int i=index;i<length;i++){
            Character ch=s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                if(num==0){
                    num=(ch-'0');
                }else{
                    num=num*10+(ch-'0');
                }
            } else {
                return new Pair(num, "", i);
            }
        }
        return null;
    }

    class Pair {
        public Pair(int num,String res,int index){
            this.num=num;
            this.res=res;
            this.index=index;
        }

        int num;
        int index;
        String res;
    }

    public static void main(String[] args) {
        Code394 code394=new Code394();
        System.out.println(code394.decodeString("100[leetcode]"));
    }

}
