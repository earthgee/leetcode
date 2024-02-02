package com.earthgee.interview;

import java.util.HashMap;

public class Code105 {

    private HashMap<Integer,Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length=preorder.length;
        indexMap=new HashMap<>();
        for(int i=0;i<length;i++){
            indexMap.put(inorder[i], i);
        }

        return internalBuildTree(preorder, inorder, 0, length-1, 0, length-1);
    }

    private TreeNode internalBuildTree(int[] preorder, int[] inorder,
                                       int preOrderLeft, int preOrderRight,
                                       int inOrderLeft, int inOrderRight){
        if(preOrderLeft > preOrderRight){
            return null;
        }

        int preRootIndex=preOrderLeft;
        int inOrderRootIndex=indexMap.get(preorder[preRootIndex]);

        TreeNode root=new TreeNode(preorder[preRootIndex]);
        int leftSize=inOrderRootIndex-inOrderLeft;
        root.left=internalBuildTree(preorder, inorder, preOrderLeft+1, preOrderLeft+leftSize, inOrderLeft, inOrderRootIndex-1);
        root.right=internalBuildTree(preorder, inorder, preOrderLeft+leftSize+1, preOrderRight, inOrderRootIndex+1, inOrderRight);
        return root;
    }

}
