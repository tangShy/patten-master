package com.leetcode.leet77;

import java.util.ArrayList;
import java.util.List;

/**
 * 77.组合  --mid
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return result;
    }

    private void dfs(int cur, int n, int k) {
        //剪枝
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        //记录答案
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        //选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        //不选当前位置
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }
}
