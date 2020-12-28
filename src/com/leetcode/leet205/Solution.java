package com.leetcode.leet205;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串   --easy
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            map.putIfAbsent(s.charAt(i), t.charAt(i));
            map2.putIfAbsent(t.charAt(i), s.charAt(i));
            sb.append(map.get(s.charAt(i)));
            sb2.append(map2.get(t.charAt(i)));
        }
        return sb2.toString().equals(s) && sb.toString().equals(t) ;
    }

    // 法二
    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (int i=0; i<s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic3(String s, String t) {
        // 官方
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic("abb", "egg");

        System.out.println(isomorphic);
    }
}
