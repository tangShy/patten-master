package com.leetcode.tree.leet530;

import com.leetcode.common.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差     ——easy
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 二叉搜索树的特点：左子树节点值 < 根节点值 < 右子树节点值
     * 1、经过一次中序遍历将值保存在一个数组中再进行遍历求解
     * 2、也可以在中序遍历的过程中用 pre 变量保存前驱节点的值，这样即能边遍历边更新答案，不再需要显式创建数组来保存
     * @param root
     * @return
     */
    private int pre, min;
    public int getMinimumDifference(TreeNode root) {

        min = Integer.MAX_VALUE;
        pre = -1;
        //遍历所有节点，计算相邻两节点最小差值的绝对值
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null ){
           return;
        }
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            min = Math.min(min, root.val-pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
