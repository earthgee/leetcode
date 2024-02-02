package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code17 {

    char[][] keymap=new char[10][4];
    List<String> result=new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        int length=digits.length();
        keymap[2]=new char[]{'a', 'b', 'c', '0'};
        keymap[3]=new char[]{'d', 'e', 'f', '0'};
        keymap[4]=new char[]{'g', 'h', 'i', '0'};
        keymap[5]=new char[]{'j', 'k', 'l', '0'};
        keymap[6]=new char[]{'m', 'n', 'o', '0'};
        keymap[7]=new char[]{'p', 'q', 'r', 's'};
        keymap[8]=new char[]{'t', 'u', 'v', '0'};
        keymap[9]=new char[]{'w', 'x', 'y', 'z'};

        if(length==0){
            return result;
        }

        findAllKeyMap(digits, 0, new ArrayList<Character>());
        return result;
    }

    private void findAllKeyMap(String digits,int index, List<Character> store){
        if(index == digits.length()){
           StringBuilder stringBuilder=new StringBuilder();
           for(Character character:store){
               stringBuilder.append(character);
           }
           result.add(stringBuilder.toString());
           return;
        }

        int code=digits.charAt(index)-'0';
        for(int i=0;i<4;i++){
            if(keymap[code][i]!='0'){
                store.add(keymap[code][i]);
                findAllKeyMap(digits, index+1, store);
                store.remove(store.size()-1);
            }
        }
    }


}
