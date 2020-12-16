package com.leetcode.leet290;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律    --easy
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] ch = pattern.toCharArray();
        String[] s1 = s.split(" ");
        int pLen = ch.length;
        int sLen = s1.length;
        if (pLen != sLen) {
            return false;
        }
        Map<Character, Integer> pMap = new HashMap<>();
        Map<String, Integer> sMap = new HashMap<>();
        pMap.put(ch[0], 0);
        sMap.put(s1[0], 0);
        int index = 1;
        while (index < pLen) {
            if ((ch[index] == ch[index-1] && !s1[index].equals(s1[index-1])) ||
                    (ch[index] != ch[index-1] && s1[index].equals(s1[index-1]))) {
                return false;
            }
            if (ch[index] != ch[index-1]) {
                int i = -1;
                if (pMap.containsKey(ch[index])) {
                    i = pMap.get(ch[index]);
                }
                if (i != -1 && !s1[index].equals(s1[i])) {
                    return false;
                }else if (i == -1 && sMap.containsKey(s1[index])) {
                    return false;
                }
            }
            pMap.put(ch[index], index);
            sMap.put(s1[index], index);
            index++;
        }
        return true;
    }
}
