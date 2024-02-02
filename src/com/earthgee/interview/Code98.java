package com.earthgee.interview;

import java.util.LinkedList;

public class Code98 {

    public boolean isValidBST(TreeNode root) {
        int lastval = Integer.MIN_VALUE;
        boolean isFirst=true;
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            TreeNode node=stack.pop();
            if(!isFirst && node.val<=lastval){
                return false;
            }
            isFirst=false;
            lastval=node.val;
            cur=node.right;
        }

        return true;
    }

}
