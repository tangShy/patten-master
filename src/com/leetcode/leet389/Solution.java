package com.leetcode.leet389;

/**
 * 389. 找不同     --easy
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static char findTheDifference(String s, String t) {
        //
//        char[] ch = t.toCharArray();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            for (int j = 0; j < ch.length; j++) {
//                if (c == ch[j]) {
//                    ch[j] = '1';
//                    break;
//                }
//            }
//        }
//        for (char cc : ch) {
//            if (cc != '1') {
//                return cc;
//            }
//        }
//        return ' ';

        // 计数法
//        int[] nums = new int[26];
//        for (int i=0; i<s.length(); i++) {
//            char ch = s.charAt(i);
//            nums[ch - 'a']++;
//        }
//        for (int j=0; j<t.length(); j++) {
//            char ch = t.charAt(j);
//            nums[ch - 'a']--;
//            if (nums[ch - 'a'] < 0) {
//                return ch;
//            }
//        }
//        return ' ';

//        // 求和
//        int as = 0, at = 0;
//        for (int i = 0; i < s.length(); i++) {
//            as += s.charAt(i);
//        }
//        for (int j = 0; j < t.length(); j++) {
//            at += t.charAt(j);
//        }
//        return (char) (at - as);

        // 位运算,异或：转换为二进制之后，相同位同则为0，不同则为1
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i);
        }
        for (int j = 0; j < t.length(); j++) {
            ret ^= t.charAt(j);
        }
        return (char) ret;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abacd";
        System.out.println(findTheDifference(s, t));
    }
}
