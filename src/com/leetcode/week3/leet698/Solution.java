package com.leetcode.week3.leet698;

/**
 * @Author tang
 * @Date 2021/9/5 22:57
 */
// 698.划分为k个相等的子集
public class Solution {
    // 从桶的视角出发，每个桶需要遍历所有数字，决定是否将当前数字放入桶中；当装满一个桶之后，还要装下一个桶，知道所有桶装满
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int s : nums) {
            sum += s;
        }
        if (sum % k != 0) return false;
        // 每个桶数字之和为 sum/k
        int target = sum / k;
        // 记录被使用过了的数字
        boolean[] used = new boolean[nums.length];

        // k号桶初始什么都没装，从nums[0]开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }

    private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        // 所有桶被装满了
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            return backtrack(k - 1, 0, nums, 0, used, target);
        }

        // 从 start 开始，反向探查有效的 nums[i] 装入桶中
        for (int i = start; i < nums.length; i++) {
            // 剪枝操作
            if (used[i]) {
                continue;
            }
            // 当前桶放不下nums[i]
            if (nums[i] + bucket > target) {
                continue;
            }
            // 选择将 nums[i] 加入桶中
            used[i] = true;
            bucket += nums[i];
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            used[i] = false;
            bucket -= nums[i];
        }
        return false;
    }
}
