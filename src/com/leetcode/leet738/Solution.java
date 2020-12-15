package com.leetcode.leet738;

/**
 * 738. 单调递增的数字     --mid
 * <p>
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 思路：从右往左遍历，如果当前位置数字比左边位置数字小，则将当前位置数字置为9，左边数字-1
     *
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        char[] ch = String.valueOf(N).toCharArray();
        int len = ch.length;
        int flag = len;  // 记录从第几位开始，后面数字全都需要置为9
        for (int i = len - 1; i >= 1; i--) {
            if (ch[i] < ch[i - 1]) {
                flag = i;
                ch[i - 1] -= 1;
            }
        }
        for (int j = flag; j < len; j++) {
            ch[j] = '9';
        }
        return Integer.parseInt(new String(ch));
    }
}
