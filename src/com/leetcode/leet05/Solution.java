package com.leetcode.leet05;

/**
 * 5. 最长回文子串    --mid
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (j - i + 1 > result.length() && isReverse(s.substring(i, j))) {
                    String temp = s.substring(i, j);
                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    private boolean isReverse(String substring) {
        for (int i = 0; i < substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // 动态规划法
    public static String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j+i < n; j++) {
                int k = i + j;
                if (i == 0) {
                    dp[j][k] = true;
                } else if (i == 1) {
                    dp[j][k] = (s.charAt(j) == s.charAt(k));
                } else {
                    dp[j][k] = (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1]);
                }
                if (dp[j][k] && i + 1 > ans.length()) {
                    ans = s.substring(j, i + j + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome2("ababa"));
    }
}
