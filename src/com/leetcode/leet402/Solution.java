package com.leetcode.leet402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字  --mid
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        }

        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        for (int i=0; i<len; i++){
            char c = num.charAt(i);
            while(!deque.isEmpty() && k>0 && deque.peekLast()>c) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }
        for (int i=0; i<k; i++) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (!deque.isEmpty()) {
            char ch = deque.pollFirst();
            if(flag && ch=='0'){
                continue;
            }
            flag = false;
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";

        String result = removeKdigits(num, 0);
        System.out.println(result);
        System.out.println(Integer.valueOf(result));
    }
}
