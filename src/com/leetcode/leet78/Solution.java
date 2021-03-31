package com.leetcode.leet78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集  --mid
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(temp);
        if(nums == null || nums.length == 0){
            return result;
        }
        recursion(0, result, temp, nums);
        return result;
    }

    private static void recursion(int i, List<List<Integer>> result, List<Integer> temp, int[] nums){
        for (; i<nums.length; i++){
            List<Integer> temp_ = new ArrayList<>(temp);
            temp_.add(nums[i]);
            result.add(temp_);
            recursion(i+1, result, temp_, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets.toString());
//        List<Integer> temp = new ArrayList<>();
//        temp.add(1);
//        temp.add(2);
//        List<Integer> temp_ = new ArrayList<>(temp);
//        System.out.println(temp_.toString());
    }
}
