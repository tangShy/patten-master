package com.leetcode.leet557;

/**
 * 557. 反转字符串中的单词 III  --easy
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] strings = s.split(" ");
        for(String str : strings){
            String reverse = reverse(str);
            result.append(reverse);
            result.append(" ");
        }
        return result.toString().substring(0, result.length()-1);
    }

    //反转单个字符串
    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        StringBuilder reverse = sb.reverse();
        return reverse.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
//        System.out.println(reverse(s));
        System.out.println(reverseWords(s));
    }
}
