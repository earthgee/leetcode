package com.earthgee.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Code199 {

    //广度优先搜索
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        List<Integer> result=new ArrayList<>();

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.pollFirst();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(i==size-1){
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    //深度优先搜索
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depthStack = new LinkedList<>();

        TreeNode cur = root;
        int lastDepth = -1;
        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur);
                if(lastDepth != -1) {
                    depthStack.push(lastDepth+1);
                    lastDepth = -1;
                }else if(depthStack.isEmpty()) {
                    depthStack.push(0);
                } else {
                    depthStack.push(depthStack.peek()+1);
                }
                if(result.size() == depthStack.peek()) {
                    result.add(cur.val);
                }
                cur = cur.right;
            }

            cur = stack.pop();
            lastDepth = depthStack.pop();
            cur = cur.left;
        }

        return result;
    }

    public static void main(String[] args) {
        Code199 code199=new Code199();
        TreeNode node = new TreeNode();
        node.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
        node.left = node2;
        List<Integer> result = code199.rightSideView2(node);
        result.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

}
