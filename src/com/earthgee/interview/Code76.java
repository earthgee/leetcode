package com.earthgee.interview;

import java.util.*;

public class Code76 {

    public String minWindowOrigin(String s, String t) {
        int sLength=s.length();
        int tLength=t.length();
        if(sLength<tLength){
            return "";
        }

        int left=0;
        int right=0;
        int nextLeft=-1;
        boolean findLeft=false;
        int currentMin=Integer.MAX_VALUE;
        int currentMinLeft=-1;
        int currentMinRight=-1;

        HashMap<Character,Integer> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        resetMap(map, t);
        for(int index=0;index<tLength;index++){
            Character ch=t.charAt(index);
            set.add(ch);
        }

        while(true){
            if(left>sLength-tLength){
                break;
            }

            if(!findLeft){
                if(nextLeft>0){
                    left=nextLeft;
                    findLeft=true;
                }else{
                    Character ch=s.charAt(left);
                    if(map.containsKey(ch)){
                        findLeft = true;
                    }
                }
            }

            nextLeft=-1;

            if(findLeft){
                right=left;
                while(right<sLength){
                    Character ch = s.charAt(right);
                    if(set.contains(ch) && right!=left && nextLeft==-1){
                        nextLeft=right;
                    }

                    if(map.containsKey(ch)){
                        int count=map.get(ch)-1;
                        if(count==0){
                            map.remove(ch);
                        }else{
                            map.put(ch, count);
                        }

                        if(map.isEmpty()){
                            if(right-left+1<currentMin){
                                currentMinLeft=left;
                                currentMinRight=right;
                                currentMin=right-left+1;
                            }
                            break;
                        }
                    }

                    right++;
                }

                resetMap(map, t);
                findLeft=false;
            }

            left++;
        }

        if(currentMin == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(currentMinLeft, currentMinRight+1);
        }
    }

    private void resetMap(HashMap<Character,Integer> map,String t){
        map.clear();
        int tLength=t.length();
        for(int index=0;index<tLength;index++){
            Character ch=t.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
    }

    public static void main(String[] args) {
        Code76 code76=new Code76();
        System.out.println(code76.minWindow("acccabeb", "ab"));
    }

    HashMap<Character,Integer> ori=new HashMap<>();
    HashMap<Character,Integer> cnt=new HashMap<>();
    public String minWindow(String s, String t) {
        int sLength=s.length();
        int tLength=t.length();
        if(sLength<tLength){
            return "";
        }

        for(int index=0;index<tLength;index++){
            Character ch=t.charAt(index);
            ori.put(ch, ori.getOrDefault(ch, 0)+1);
        }

        int left=0;
        int right=-1;
        int currentMin=Integer.MAX_VALUE;
        int currentMinLeft=-1;
        int currentMinRight=-1;

        while(right<sLength){
            ++right;

            if(right<sLength && ori.containsKey(s.charAt(right))){
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0)+1);
            }

            while(check() && left<=right){
                if(right-left+1<currentMin){
                    currentMinLeft=left;
                    currentMinRight=right+1;
                    currentMin=right-left+1;
                }

                if(cnt.containsKey(s.charAt(left))){
                    cnt.put(s.charAt(left),cnt.getOrDefault(s.charAt(left),0)-1);
                }
                left++;
            }
        }

        if(currentMin == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(currentMinLeft, currentMinRight);
        }
    }

    private boolean check() {
        Iterator iter=ori.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry= (Map.Entry) iter.next();
            Character key= (Character) entry.getKey();
            Integer value= (Integer) entry.getValue();
            if(cnt.getOrDefault(key,0)<value){
                return false;
            }
        }
        return true;
    }

}
