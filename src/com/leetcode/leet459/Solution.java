package com.leetcode.leet459;

/**
 * 459. 重复的子字符串  --easy
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            String subStr = s.substring(0, i + 1);
            if (isSub(subStr, s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSub(String subStr, String s) {
        int a = subStr.length();
        int b = s.length();
        int temp = a;
        while (b >= temp) {
            if (b < 2 * a || b < a+temp || !subStr.equals(s.substring(temp, a + temp))) {
                return false;
            }
            temp += a;
            if(b==temp){
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aaaabaaaabaaaab";
        System.out.println(repeatedSubstringPattern(str));
    }
}
