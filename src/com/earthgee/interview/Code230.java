package com.earthgee.interview;

import java.util.HashMap;
import java.util.Map;

public class Code230 {

    private Map<TreeNode, Integer> nodeMap=new HashMap<>();

    public int kthSmallest(TreeNode root, int k) {
        countTreeNum(root);
        return findKth(root, k).val;
    }

    private int countTreeNum(TreeNode node){
        if(node==null){
            return 0;
        }

        int nodeNum=countTreeNum(node.left)+countTreeNum(node.right)+1;
        nodeMap.put(node, nodeNum);
        return nodeNum;
    }

    private TreeNode findKth(TreeNode node,int kth){
        int leftCount=0;
        if(node.left!=null){
            leftCount=nodeMap.get(node.left);
        }

        if(leftCount+1==kth){
            return node;
        } else if(leftCount+1>kth){
            return findKth(node.left, kth);
        } else {
            return findKth(node.right, kth-leftCount-1);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.left.right=new TreeNode(2);

        Code230 code230=new Code230();
        code230.kthSmallest(root, 1);
    }

}
