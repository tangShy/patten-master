package com.leetcode.week2.leet98;

import com.leetcode.common.TreeNode;

/**
 * @Author tang
 * @Date 2021/8/30 22:57
 */
//98.验证二叉搜索树（中等）
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && min.val >= root.val) return false;
        if (max != null && max.val <= root.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
