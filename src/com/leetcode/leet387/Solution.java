package com.leetcode.leet387;

/**
 * 387. 字符串中的第一个唯一字符    --easy
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int firstUniqChar(String s) {
        int ans = -1;
        int[] nums = new int[26];  //用来存26个字母，每个字母出现的个数
        for (int i=0; i<s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }

        for (int j=0; j<s.length(); j++) {
            if (nums[s.charAt(j)-'a'] == 1) {
                return j;
            }
        }
        return ans;
    }
}
