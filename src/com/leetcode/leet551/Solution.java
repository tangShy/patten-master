package com.leetcode.leet551;

/**
 * @Author tang
 * @Date 2021/8/17 22:52
 */

/**
 * 551. 学生出勤记录 I   --easy
 *
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 *
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 1.按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 2.学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * 示例 2：
 *
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 为 'A'、'L' 或 'P'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean checkRecord(String s) {
        int absent = 0, late = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absent++;
                late = 0;
            } else if (s.charAt(i) == 'L') {
                late++;
            } else {
                late = 0;
            }
            if (absent >= 2 || late >= 3) {
                return false;
            }
        }
        return true;
    }
}