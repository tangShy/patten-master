package com.leetcode.leet31;

/**
 * 31. 下一个排列        --mid
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        // 从后往前遍历，
        // 如果当前数a 比前一个数b 大，则从当前数a 开始，往后寻找一个最小的但比b 大的数，交换这两个数，再把a至最后一个数进行逆序排序
        // 如果不存在后面的数比前面的大，则将该数组逆序排序
        int i = nums.length-2;
        while (i >=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >=0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 将数组逆序
        reverse(nums, i+1);
    }
    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length-1;
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
