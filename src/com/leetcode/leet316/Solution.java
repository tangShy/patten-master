package com.leetcode.leet316;

import java.util.Stack;

/**
 * 316. 去除重复字母  --mid
 * <p>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static String removeDuplicateLetters(String s) {
//        // 从后往前遍历
//        int n = s.length();
//        List<Character> list = new ArrayList<>();
//        char minChar = 'z';
//        for (int i = n - 1; i >= 0; i--) {
//            char c = s.charAt(i);
//            if (!list.contains(c)) {
//                list.add(c);
//                minChar = minChar < c ? minChar : c;
//            } else if (c < minChar || c < list.get(list.size()-1)) {
//                list.remove((Object) c);
//                list.add(c);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int j = list.size() - 1; j >= 0; j--) {
//            sb.append(list.get(j));
//        }
//        return sb.toString();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c))
                continue;
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1)
                stack.pop();
            stack.push(c);
        }
        char chars[] = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        removeDuplicateLetters("bcab");
    }
}
