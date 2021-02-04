package com.leetcode.leet643;

/**
 * 643. 子数组最大平均数 I      --easy
 * <p>
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
//        double ans = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            if (i > 0 && nums[i + k - 1] < nums[i - 1]) {
//                continue;
//            }
//            int temp = i + k - 1;
//            int sum = 0;
//            while (temp >= i) {
//                sum += nums[temp--];
//            }
//            double ave = (double) sum / k;
//            ans = Math.max(ans, ave);
//        }
//        return ans;

        //优化
        int maxSum = 0;
        for (int i=0; i<k; i++) {
            maxSum += nums[i];
        }
        int sum = maxSum;
        for (int i = k; i<nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }
}
