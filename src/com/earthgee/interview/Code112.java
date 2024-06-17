package com.earthgee.interview;

import java.util.LinkedList;

public class Code112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> valueQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valueQueue.offer(root.val);
        while(!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            int value = valueQueue.poll();

            if(current.left == null
                    && current.right == null) {
                if(value == targetSum) {
                    return true;
                }
            }

            if(current.left != null) {
                nodeQueue.offer(current.left);
                valueQueue.offer(current.left.val + value);
            }

            if(current.right != null) {
                nodeQueue.offer(current.right);
                valueQueue.offer(current.right.val + value);
            }
        }

        return false;
    }

}
