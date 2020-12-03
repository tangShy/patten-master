package com.leetcode.leet204;

import java.util.Arrays;

/**
 * 204. 计数质数    --easy
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 法一：枚举
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int ans = 1;
        // 质数统计
        for (int i=3; i<n; i++) {
            boolean flag = true;
            for (int j=2; j * j <= i; j++){
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }

    // 法二：埃氏筛
    public static int countPrimes2(int n) {
        int ans = 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i=2; i<n; i++) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long)i*i < n){
                    for (int j=i*i; j<n; j+=i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = countPrimes2(1500000);
        System.out.println(ans);
    }
}
