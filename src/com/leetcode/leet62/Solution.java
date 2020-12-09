package com.leetcode.leet62;

/**
 * 62. 不同路径     --mid
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //递归法
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int ans = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        return ans;
    }

    //动态规划
    public static int uniquePaths2(int m, int n) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            ans[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i][j - 1] + ans[i - 1][j];
            }
        }
        return ans[m - 1][n - 1];
    }

    // 组合数学
    public static int uniquePaths3(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(uniquePaths(51, 9));
        System.out.println(System.currentTimeMillis());
        System.out.println(uniquePaths2(51, 9));
        System.out.println(System.currentTimeMillis());
        System.out.println(uniquePaths3(51, 9));
        System.out.println(System.currentTimeMillis());
    }
}
