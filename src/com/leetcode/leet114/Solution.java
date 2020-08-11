package com.leetcode.leet114;

import com.leetcode.leet108.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void flatten(TreeNode root) {
//        if(root == null) return;
//        flatten(root.left);
//        flatten(root.right);
//
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = null;
//        while(root.right != null) root = root.right;
//        root.right = temp;


        //题解：寻找前驱节点
        TreeNode curr = root;
        while (curr != null){
            if(curr.left != null){
                TreeNode next = curr.left;
                TreeNode pre = next;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
