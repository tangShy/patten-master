package com.leetcode.leet_game42.leet5624;

/**
 * 5624. 得到连续 K 个 1 的最少相邻交换次数   --hard
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。
 * <p>
 * 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：1
 * 解释：在第一次操作时，nums 可以变成 [1,0,0,0,1,1] 得到连续两个 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,0,0,0,0,1,1], k = 3
 * 输出：5
 * 解释：通过 5 次操作，最左边的 1 可以移到右边直到 nums 变为 [0,0,0,0,0,1,1,1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,0,1], k = 2
 * 输出：0
 * 解释：nums 已经有连续 2 个 1 了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 要么是 0 ，要么是 1 。
 * 1 <= k <= sum(nums)
 */

// TODO: 待完善
public class Solution {
    public int minMoves(int[] nums, int k) {
        int count = 0; // 记录连续1的个数
        int index = 0; // 记录连续1的起始下标
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
                index = i;
            } else {
                count = Math.max(count, temp);
                temp = 0;
            }
        }
        count = Math.max(count, temp);
        if (count >= k) {
            return 0;
        }
        int ans = k - count;    // 相差1的个数
        int ret = 0, ret1 = 0, ret2 = 0;
        int indexTemp1 = index - 1;
        int indexTemp2 = index + k + 1;
        for (int j = 0; j < ans; j++) {
            while (indexTemp1 >= 0) {
                if (nums[indexTemp1] == 1) {
                    ret1 += index - 1 - indexTemp1;
                    break;
                }
                indexTemp1--;
            }
            while (indexTemp2 < nums.length) {
                if (nums[indexTemp2] == 1) {
                    ret2 += indexTemp2 - (index + count);
                    break;
                }
                indexTemp2++;
            }
            ret = Math.min(ret1, ret2);
        }
        return ret;
    }
}
