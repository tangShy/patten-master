package com.leetcode.leet378;

import java.util.Arrays;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static int kthSmallest(int[][] matrix, int k) {
        //法1：转换成一个一维数组，直接返回第k个元素即可
        int n = matrix.length;
        int[] dp = new int[n*n];
        int num = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[num++] = matrix[i][j];
            }
        }
        Arrays.sort(dp);
        return dp[k-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2},{1,2}};
        int i = kthSmallest(matrix, 2);
        System.out.println(i);
    }
}
