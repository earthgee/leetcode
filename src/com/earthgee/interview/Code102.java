package com.earthgee.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        List<List<Integer>> result=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode head=queue.pollFirst();
                list.add(head.val);
                if(head.left!=null){
                    queue.offer(head.left);
                }
                if(head.right!=null){
                    queue.offer(head.right);
                }
            }

            result.add(list);
        }

        return result;
    }

}
