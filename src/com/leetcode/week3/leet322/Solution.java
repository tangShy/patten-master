package com.leetcode.week3.leet322;

import java.util.Arrays;

/**
 * @Author tang
 * @Date 2021/9/7 22:57
 */
// 322.零钱兑换（中等）
public class Solution {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount);
    }
    public int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

//    public static void main(String[] args) {
//        int[] coins = {1,2,5};
//        dp(coins, 11);
//    }
}
