package com.leetcode.week3.leet509;

/**
 * @Author tang
 * @Date 2021/9/7 22:33
 */
// 509.斐波那契数列（简单）
public class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
