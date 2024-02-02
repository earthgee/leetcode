package com.earthgee.interview;

public class Code48 {

    public void rotate(int[][] matrix) {
        int length=matrix.length;

        int maxRow=length/2;
        int maxCol=length%2==0?length/2:length/2+1;
        for(int row=0;row<maxRow;row++){
            for(int col=0;col<maxCol;col++){
                int tmp=matrix[row][col];
                matrix[row][col]=matrix[length-col-1][row];
                matrix[length-col-1][row]=matrix[length-row-1][length-col-1];
                matrix[length-row-1][length-col-1]=matrix[col][length-row-1];
                matrix[col][length-row-1]=tmp;
            }
        }
    }

}
