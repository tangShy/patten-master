package com.leetcode.leet977;

/**
 * 977. 有序数组的平方     --easy
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        //法一：直接排序
//        int[] ans = new int[A.length];
//        for (int i=0; i<A.length; i++){
//            ans[i] = A[i] * A[i];
//        }
//        Arrays.sort(ans);
//        return ans;

        //法二：双指针
        int n = A.length;
        int[] ans = new int[n];
        for (int i=0, j=n-1, pos=n-1; i<=j; ){
            if (A[i] * A[i] >= A[j]* A[j]){
                ans[pos] = A[i] * A[i];
                i++;
            } else {
                ans[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
