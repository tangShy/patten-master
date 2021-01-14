package com.leetcode.leet1018;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀  --easy
 * <p>
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * <p>
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 * <p>
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 * <p>
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 * <p>
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();

        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num <<= 1;
            num += A[i];
            num %= 10;
            ans.add(num % 5 == 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,0,1};
        List<Boolean> booleans = prefixesDivBy5(A);
        booleans.forEach(System.out::println);
    }
}
