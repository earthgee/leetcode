package com.earthgee.interview;


public class Code226 {

    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode node){
        if(node==null){
            return;
        }

        TreeNode tmp=node.left;
        node.left=node.right;
        node.right=tmp;

        reverse(node.left);
        reverse(node.right);
    }

}
