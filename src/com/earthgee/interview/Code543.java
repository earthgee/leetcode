package com.earthgee.interview;

public class Code543 {

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int depthLeft=depth(node.left);
        int depthRight=depth(node.right);
        if(depthLeft + depthRight > max) {
            max = depthLeft + depthRight;
        }
        return Math.max(depthLeft, depthRight)+1;
    }

    public static void main(String[] args) {
        Code543 code543 = new Code543();
        TreeNode node = new TreeNode();
        node.val = 1;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
        node.left = node2;
        code543.diameterOfBinaryTree(node);
    }

}
