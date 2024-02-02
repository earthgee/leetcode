package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code51 {

    private List<List<String>> result=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] matrix=new boolean[n][n];
        solve(matrix, 0, n);
        return result;
    }

    private void solve(boolean[][] matrix, int currentRow, int length) {
        if(currentRow==length){
            List<String> list=new ArrayList<>();
            for(int i=0;i<length;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<length;j++){
                    if(matrix[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }

                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        for(int i=0;i<length;i++){
            if(!isCorrect(matrix, currentRow, i, length)) {
                continue;
            }

            matrix[currentRow][i]=true;
            solve(matrix, currentRow+1, length);
            matrix[currentRow][i]=false;
        }
    }

    private boolean isCorrect(boolean[][] matrix, int currentRow, int currentCol, int length) {
        if(currentRow == 0){
            return true;
        }

        //检查列
        for(int i=0;i<length;i++){
            if(matrix[i][currentCol]) {
                return false;
            }
        }

        //检查对角线
        int row=currentRow-1;
        int col=currentCol-1;
        while(row>=0 && col>=0){
            if(matrix[row][col]){
                return false;
            }

            row--;
            col--;
        }

        row=currentRow+1;
        col=currentCol+1;
        while(row<length&&col<length){
            if(matrix[row][col]){
                return false;
            }

            row++;
            col++;
        }

        row=currentRow-1;
        col=currentCol+1;
        while(row>=0 && col<length){
            if(matrix[row][col]){
                return false;
            }

            row--;
            col++;
        }

        row=currentRow+1;
        col=currentCol-1;
        while(row<length&&col>=0){
            if(matrix[row][col]){
                return false;
            }

            row++;
            col--;
        }

        return true;
    }

    public static void main(String[] args) {
        Code51 code51=new Code51();
        code51.solveNQueens(3);
    }

}
