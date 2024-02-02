package com.earthgee.interview;

public class Code79 {

    char[][] board;
    String word;
    boolean[][] visited;
    int row;
    int col;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        row=board.length;
        col=board[0].length;
        visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(search(i,j,0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(int searchRow, int searchCol, int index){
        if(board[searchRow][searchCol]!=word.charAt(index)){
           return false;
        }
        if(index == word.length()-1){
            return true;
        }

        visited[searchRow][searchCol]=true;
        boolean flag=false;
        for(int i=0;i<4;i++){
            if(i==0 && searchCol-1>=0 && !visited[searchRow][searchCol-1]){
                if(search(searchRow, searchCol-1, index+1)){
                    flag = true;
                    break;
                }
            }

            if(i==1 && searchRow-1>=0 && !visited[searchRow-1][searchCol]){
                if(search(searchRow-1, searchCol, index+1)){
                    flag = true;
                    break;
                }
            }

            if(i==2 && searchCol+1<col && !visited[searchRow][searchCol+1]){
                if(search(searchRow, searchCol+1, index+1)){
                    flag=true;
                    break;
                }
            }

            if(i==3 && searchRow+1<row && !visited[searchRow+1][searchCol]){
                if(search(searchRow+1, searchCol, index+1)){
                    flag=true;
                    break;
                }
            }
        }

        visited[searchRow][searchCol]=false;
        return flag;
    }

}
