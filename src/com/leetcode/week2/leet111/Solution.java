package com.leetcode.week2.leet111;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author tang
 * @Date 2021/9/1 20:56
 */
//111. 二叉树的最小深度  --easy
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
