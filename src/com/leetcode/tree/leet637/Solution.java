package com.leetcode.tree.leet637;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. 二叉树的层平均值  --easy
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //深度优先遍历方法
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(sums, counts, 0, root);
        for (int i=0; i<sums.size(); i++){
            result.add(sums.get(i)/counts.get(i));
        }
        return result;
    }

    private void dfs(List<Double> sums, List<Integer> counts, int level, TreeNode root) {
        if (root == null){
            return;
        }
        if(level < sums.size()){
            sums.set(level, sums.get(level)+root.val);
            counts.set(level, counts.get(level)+1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(sums, counts, level+1, root.left);
        dfs(sums, counts, level+1, root.right);
    }

}
