package com.leetcode.leet242;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词   --easy
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("".length());
        boolean flag = isAnagram("", "");
        System.out.println(flag);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int j=0; j<t.length(); j++) {
            if (!map2.containsKey(t.charAt(j))) {
                map2.put(t.charAt(j), 1);
            } else {
                map2.put(t.charAt(j), map2.get(t.charAt(j)) + 1);
            }
        }
        if (map.size() != map2.size()) {
            return false;
        }

        boolean flag = false;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            flag = false;
            for (int k=0; k<map2.size(); k++) {
                if (map2.get(m.getKey()).equals(m.getValue())) {
                    flag = true;
                    break;
                }
                if (k == map2.size()-1) {
                    return false;
                }
            }
        }

        return flag;
    }
}
