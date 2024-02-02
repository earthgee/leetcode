package com.earthgee.interview;

public class Code236 {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }

        boolean lson=dfs(root.left, p, q);
        boolean rson=dfs(root.right, p, q);
        if((lson&&rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
