package com.earthgee.interview;

public class Code124 {

    private int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if(node==null) {
            return 0;
        }

        int leftScore=Math.max(dfs(node.left), 0);
        int rightScore=Math.max(dfs(node.right), 0);
        int score=node.val+leftScore+rightScore;

        if(score>maxSum){
            maxSum=score;
        }

        return node.val + Math.max(leftScore, rightScore);
    }

}
