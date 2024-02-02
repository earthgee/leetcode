package com.earthgee.interview;

import java.util.ArrayList;
import java.util.List;

public class Code207 {

    List<List<Integer>> edges;
    int[] visited;
    boolean valid=true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            edges.add(new ArrayList<>());
        }
        for(int[] courses:prerequisites){
            edges.get(courses[1]).add(courses[0]);
        }

        visited=new int[numCourses];
        for(int i=0;i<numCourses && valid;i++){
            if(visited[i]==0){
                dfs(i);
            }
        }

        return valid;
    }

    private void dfs(int index) {
        visited[index]=1;
        for(int edge : edges.get(index)) {
            if(visited[edge]==0){
                dfs(edge);
                if(!valid){
                    return;
                }
            } else if(visited[edge] == 1){
                valid=false;
                return;
            }
        }
        visited[index]=2;
    }

}
