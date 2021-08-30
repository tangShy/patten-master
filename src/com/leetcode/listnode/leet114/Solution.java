package com.leetcode.listnode.leet114;

import com.leetcode.common.TreeNode;

/**
 * @Author tang
 * @Date 2021/8/29 23:07
 */
//114. 二叉树展开为链表
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}
