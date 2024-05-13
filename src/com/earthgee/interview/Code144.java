package com.earthgee.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//二叉树先序遍历
public class Code144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(cur!=null || stack.isEmpty()) {
            while(cur!=null){
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur=stack.pop();
            cur=cur.right;
        }

        return result;
    }

}
