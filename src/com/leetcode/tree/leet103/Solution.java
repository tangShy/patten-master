package com.leetcode.tree.leet103;

import com.leetcode.common.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历     --mid
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 层序遍历 + 奇偶行数判断
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int flag = 0; //用来标记当前是第几行，奇数行则正常添加val，偶数行则反转val
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            flag++;
            int n = queue.size();
            Deque<Integer> temp = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                if (flag % 2 != 0) {
                    temp.offerLast(poll.val);
                } else {
                    temp.offerFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            ans.add(new LinkedList<>(temp));
        }
        return ans;
    }
}
