package com.leetcode.leet242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 代码优化版
public class Solution2 {
    // 法一：排序法
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    // 法二：哈希表
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            table[t.charAt(j) - 'a']--;
            if (table[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    // 进阶版
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            map.put(t.charAt(j), map.getOrDefault(t.charAt(j), 0) - 1);
            if (map.get(t.charAt(j)) < 0) {
                return false;
            }
        }
        return true;
    }
}
