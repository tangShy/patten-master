package com.leetcode.leet509;

/**
 * 509. 斐波那契数       --easy
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int fib(int n) {
        // 法一：递归
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return fib(n-1) + fib(n-2);

//        法二：递归优化
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        int[] nums = new int[n + 1];
//        Arrays.fill(nums, 0);
//        nums[0] = 0;
//        nums[1] = 1;
//        if (nums[n] != 0) {
//            return nums[n];
//        }
//        nums[n] = fib(n - 1) + fib(n - 2);
//        return nums[n];

//        法三：迭代
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        int[] nums = new int[n + 1];
//        nums[0] = 0;
//        nums[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            nums[i] = nums[i - 2] + nums[i - 1];
//        }
//        return nums[n];

        //法四：迭代优化
        if (n < 2) return n;
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
