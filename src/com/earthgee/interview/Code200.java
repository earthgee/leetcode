package com.earthgee.interview;

public class Code200 {

    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int result=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,row,col);
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid,int row,int col,int rowMax,int colMax) {
        if(row<0 || col<0|| row>=rowMax || col>=colMax){
            return;
        }
        if(grid[row][col]=='0'){
            return;
        }

        grid[row][col]='0';
        dfs(grid,row-1,col,rowMax,colMax);
        dfs(grid, row+1,col,rowMax,colMax);
        dfs(grid,row,col-1,rowMax,colMax);
        dfs(grid,row,col+1,rowMax,colMax);
    }

}
