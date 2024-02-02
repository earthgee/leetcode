package com.earthgee.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code199 {

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

}
