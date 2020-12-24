package com.leetcode.leet135;

/**
 * 135. 分发糖果    --hard
 *
 * <p>
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static int candy(int[] ratings) {
        // 两次遍历
        int n = ratings.length;
        int[] nums = new int[n];
        // 从左往右遍历
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            } else {
                nums[i] = 1;
            }
        }

        // 从右往左遍历
        for (int j = n - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1] && nums[j] <= nums[j + 1]) {
                nums[j] = nums[j + 1] + 1;
            }
        }

        // 计算总糖果
        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }
}
