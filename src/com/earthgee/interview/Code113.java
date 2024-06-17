package com.earthgee.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Code113 {

    List<List<Integer>> res = new ArrayList<>();
    HashMap<TreeNode, TreeNode> indexMap = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return res;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> valueQueue = new LinkedList<>();

        nodeQueue.offer(root);
        valueQueue.offer(root.val);
        while(!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            int curVal = valueQueue.poll();

            if(curNode.left == null && curNode.right == null) {
                if(curVal == targetSum) {
                    List<Integer> resList = new ArrayList<>();
                    TreeNode temp = curNode;
                    resList.add(temp.val);
                    while(indexMap.containsKey(temp)) {
                        temp = indexMap.get(temp);
                        resList.add(0, temp.val);
                    }
                    res.add(resList);

                    continue;
                }
            }

            if(curNode.left != null) {
                nodeQueue.offer(curNode.left);
                valueQueue.offer(curVal + curNode.left.val);
                indexMap.put(curNode.left, curNode);
            }

            if(curNode.right != null) {
                nodeQueue.offer(curNode.right);
                valueQueue.offer(curVal + curNode.right.val);
                indexMap.put(curNode.right, curNode);
            }
        }

        return res;
    }

}
