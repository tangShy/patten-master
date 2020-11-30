package com.leetcode.leet767;

/**
 * 767. 重构字符串   --mid
 * <p>
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        if (len < 2) {
            return S;
        }
        int[] nums = new int[26]; // 用于存储S字符串中每个字符有多少位
        int max = 0;    // 记录nums数组中，最大的那个值（即最多个数的字符）
        for (int i = 0; i < len; i++) {
            nums[S.charAt(i) - 'a']++;
            max = Math.max(max, nums[S.charAt(i) - 'a']);
        }

        // 如果数组中最大的那个数大于字符串总长的一半或一半+1，则直接返回""
        if (max > (len + 1) / 2) {
            return "";
        }

        // 重新排列字符串
        char[] ans = new char[len];
        int enentIndex = 0, oddIndex = 1;
        for (int j = 0; j < 26; j++) {
            char ch = (char) ('a' + j);
            while (nums[j] > 0 && nums[j] <= len / 2 && oddIndex < len) {
                ans[oddIndex] = ch;
                oddIndex += 2;
                nums[j]--;
            }
            while (nums[j] > 0) {
                ans[enentIndex] = ch;
                enentIndex += 2;
                nums[j]--;
            }
        }
        return new String(ans);
    }
}
