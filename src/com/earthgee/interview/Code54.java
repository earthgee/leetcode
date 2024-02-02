package com.earthgee.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code54 {

    enum Arrow{
        UP, DOWN, LEFT, RIGHT;
    }

    static class NextData {

        public NextData(int row, int col, boolean stop, Arrow arrow) {
            this.row = row;
            this.col = col;
            this.stop = stop;
            this.arrow = arrow;
        }

        int row;
        int col;
        boolean stop;
        Arrow arrow;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        Arrow currentArrow=Arrow.RIGHT;
        int currentRow=0;
        int currentCol=0;
        NextData data=new NextData(currentRow, currentCol, false,currentArrow);

        List<Integer> result=new ArrayList<>();

        do {
            result.add(matrix[data.row][data.col]);
            matrix[data.row][data.col]=Integer.MIN_VALUE;
        } while(!(data=getNextData(data,row,col,matrix)).stop);

        return result;
    }

    private NextData getNextData(NextData currentData,int row,int col,int[][] matrix){
        int currentRow= currentData.row;
        int currentCol= currentData.col;
        switch (currentData.arrow){
            case UP:
                if((currentRow-1)<0 || matrix[currentRow-1][currentCol]==Integer.MIN_VALUE) {
                    if((currentCol+1)>=col||matrix[currentRow][currentCol+1]==Integer.MIN_VALUE){
                        return new NextData(0,0,true,Arrow.UP);
                    }else{
                        return new NextData(currentRow,currentCol+1,false,Arrow.RIGHT);
                    }
                } else {
                    return new NextData(currentRow-1, currentCol, false, Arrow.UP);
                }
            case DOWN:
                if((currentRow+1)>=row || matrix[currentRow+1][currentCol]==Integer.MIN_VALUE){
                    if((currentCol-1)<0||matrix[currentRow][currentCol-1]==Integer.MIN_VALUE){
                        return new NextData(0,0,true,Arrow.UP);
                    }else {
                        return new NextData(currentRow,currentCol-1,false,Arrow.LEFT);
                    }
                }else {
                    return new NextData(currentRow+1, currentCol, false, Arrow.DOWN);
                }
            case LEFT:
                if((currentCol-1)<0||matrix[currentRow][currentCol-1]==Integer.MIN_VALUE){
                    if((currentRow-1)<0||matrix[currentRow-1][currentCol]==Integer.MIN_VALUE){
                        return new NextData(0,0,true,Arrow.UP);
                    }else{
                        return new NextData(currentRow-1,currentCol,false,Arrow.UP);
                    }
                }else{
                    return new NextData(currentRow,currentCol-1,false, Arrow.LEFT);
                }
            case RIGHT:
                if((currentCol+1)>=col || matrix[currentRow][currentCol+1]==Integer.MIN_VALUE){
                    if((currentRow+1)>=row||matrix[currentRow+1][currentCol]==Integer.MIN_VALUE){
                        return new NextData(0,0,true,Arrow.UP);
                    }else{
                        return new NextData(currentRow+1,currentCol,false,Arrow.DOWN);
                    }
                }else{
                    return new NextData(currentRow,currentCol+1,false,Arrow.RIGHT);
                }
        }
        return null;
    }

}
