package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> current=new ArrayList<>();
            if(i==0){
                current.add(1);
                result.add(current);
            }else if(i==1){
                current.add(1);
                current.add(1);
                result.add(current);
            }else{
                current.add(1);
                List<Integer> last=result.get(i-1);
                int length=last.size();
                for(int j=0,k=1;k<length;j++,k++){
                    current.add(last.get(j)+last.get(k));
                }
                current.add(1);
                result.add(current);
            }
        }
        return result;
    }

}
