package com.earthgee.interview;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 */
public class Code994 {

    int[] dr={-1,0,1,0};
    int[] dc={0,-1,0,1};

    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        LinkedList<Integer> queue=new LinkedList<>();
        HashMap<Integer,Integer> depth=new HashMap<>();
        //找出所有腐烂的橘子
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    int code = i*col+j;
                    queue.offer(code);
                    depth.put(code, 0);
                }
            }
        }

        int ans=0;
        while(!queue.isEmpty()){
            int code=queue.poll();
            int r=code/col;
            int c=code%col;
            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(0<=nr&&nr<row&&0<=nc&&nc<col&&grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    int ncode=nr*col+nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code)+1);
                    ans=depth.get(ncode);
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }

}
