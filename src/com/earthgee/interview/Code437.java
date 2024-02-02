package com.earthgee.interview;

import java.util.HashSet;

public class Code437 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        int result=rootSum(root, targetSum);
        result+=pathSum(root.left, targetSum);
        result+=pathSum(root.right, targetSum);
        return result;
    }

    private int rootSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }

        int ret=0;
        if(root.val==targetSum){
            ret++;
        }

        if(root.val>0 && targetSum-root.val>targetSum){
            return ret;
        }

        ret+=rootSum(root.left, targetSum-root.val);
        ret+=rootSum(root.right, targetSum-root.val);
        return ret;
    }

}
