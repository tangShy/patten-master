package com.leetcode.week3.leet46;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author tang
 * @Date 2021/9/4 11:12
 */
// 46.全排列（中等）
public class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录【路径】
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在track中
    // 选择列表：nums 中的元素不在 track 中的
    // 结束条件：nums 中的元素全都在 track 中
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}
