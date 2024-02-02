package com.earthgee.interview;

public class Code108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int length=nums.length;
        int mid=(length-1)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=tree(nums, 0, mid-1);
        root.right=tree(nums, mid+1, length-1);
        return root;
    }

    private TreeNode tree(int[] nums,int left,int right){
        if(left>right){
            return null;
        }

        int mid=left+(right-left)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=tree(nums, left, mid-1);
        node.right=tree(nums, mid+1, right);
        return node;
    }

}
