package com.leetcode.leet1370;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1370. 上升下降字符串    --easy
 *
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 *
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 *
 * 输入：s = "spo"
 * 输出："ops"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String sortString(String s) {
        if (s == null || s.trim().length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        //先将s按升序排序
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        Map<Character, Integer> map = new HashMap<>();  //用来存储26个字母，每个字母的个数
        for (int i=0; i<temp.length; i++){
            map.put(temp[i], map.getOrDefault(temp[i], 0)+1);
        }
        if (map.size() == temp.length) {
            return sb.append(temp).toString();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
//            System.out.println(entry.getKey() + "——" + entry.getValue());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leetcode";
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();  //用来存储26个字母，每个字母的个数
        for (int i=0; i<temp.length; i++){
            map.put(temp[i], map.getOrDefault(temp[i], 0)+1);
        }
//        System.out.println(map.entrySet());
        if (map.size() == temp.length) {
            sb.append(temp).toString();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "——" + entry.getValue());
            entry.setValue(entry.getValue() - 1);
            System.out.println(entry.getKey() + "——" + entry.getValue());
//            if (entry.getValue() <= 0) {
//                map.remove(entry.getKey());
//            }
        }
        System.out.println(sb);
    }
}
