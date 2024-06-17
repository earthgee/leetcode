package com.earthgee.interview;

import java.util.ArrayList;
import java.util.LinkedList;
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
        //a->b 意味着a是b的前置
        for(int[] courses:prerequisites){
            edges.get(courses[1]).add(courses[0]);
        }

        visited=new int[numCourses];
        for(int i=0;i < numCourses && valid;i++){
            if(visited[i]==0){
                dfs(i);
            }
        }

        return valid;
    }

    //深度优先搜素
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

    int[] indeg;
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int num = 0;
        edges = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            edges.add(new ArrayList<>());
        }
        //节点入度数组
        indeg = new int[numCourses];
        //a->b 意味着a是b的前置
        for(int[] courses:prerequisites){
            edges.get(courses[1]).add(courses[0]);
            indeg[courses[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            num++;
            for(int nextCourse: edges.get(course)) {
                indeg[nextCourse]--;
                if(indeg[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return num == numCourses;
    }

}
