package com.leetcode.week2.leet226;

import com.leetcode.common.TreeNode;

/**
 * @Author tang
 * @Date 2021/8/29 23:07
 */
//226. 翻转二叉树
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
