package com.leetcode.leet90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II    --mid
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        ans.add(temp);
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        recursion(0, ans, temp, nums);
        return ans;
    }

    private static void recursion(int i, List<List<Integer>> ans, List<Integer> temp, int[] nums) {
        for (;i<nums.length;i++) {
            List<Integer> temp_ = new ArrayList<>(temp);
            temp_.add(nums[i]);
            if (!ans.contains(temp_)) {
                ans.add(temp_);
            }
            recursion(i+1, ans, temp_, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        System.out.println(subsets.toString());
//        List<Integer> temp = new ArrayList<>();
//        temp.add(1);
//        temp.add(2);
//        List<Integer> temp_ = new ArrayList<>(temp);
//        System.out.println(temp_.toString());
    }
}
