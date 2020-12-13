package com.leetcode.leet217;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素  --easy
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        //排序法
//        Arrays.sort(nums);
//
//        for (int i=0; i<nums.length-1; i++) {
//            if (nums[i] == nums[i+1]) {
//                return true;
//            }
//        }
//
//        return false;

        // 使用流
//        return Arrays.stream(nums).distinct().count() < nums.length;

        // 哈希表
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            // 该方法返回值为 boolean 对象，如果 Set 集合中不包含要添加的对象，则添加对象并返回 true，否则返回 false。
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4};
        System.out.println(containsDuplicate(nums));
    }
}
