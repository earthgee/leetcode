package com.earthgee.interview;

import java.util.LinkedList;

public class Code114 {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        TreeNode prev=null;
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            if(prev!=null){
                prev.left=null;
                prev.right=cur;
            }
            TreeNode left=cur.left;
            TreeNode right=cur.right;
            if(left!=null){
                stack.push(left);
            }
            if(right!=null){
                stack.push(right);
            }
            prev=cur;
        }
    }

}
