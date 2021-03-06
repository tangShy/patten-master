package com.leetcode.tree.leet222;

import com.leetcode.common.TreeNode;

/**
 * 222. 完全二叉树的节点个数      --mid
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int countNodes(TreeNode root) {
//        int ans = 0;
//        if (root == null) {
//            return 0;
//        }
//        int temp = 0; // 树的深度
//        TreeNode tempTree = root;
//        while (tempTree != null) {
//            temp++;
//            tempTree = tempTree.left;
//        }
//        for (int i=0; i<temp-1; i++) {
//            ans += (int) Math.pow(2, i);
//        }
//
//        // 计算最底下一层节点个数？
//        return ans;
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);     //左子树高度
        int right = getDepth(root.right);   //右子树高度
        if (left == right) {
            return 1 << left + countNodes(root.right);
        } else {
            return 1 << right + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        int level =0;
        while (node != null) {
            level++;
            node = node.left;
        }
        return level;
    }

}
