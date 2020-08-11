package com.leetcode.leet415;

/**
 * 415. 字符串相加 --easy
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static String addStrings(String num1, String num2) {
        int n1=num1.length()-1, n2=num2.length()-1, add = 0;
        StringBuilder sb = new StringBuilder();
        while(n1>=0 || n2>=0 || add !=0){
            int a = n1>=0 ? num1.charAt(n1)-'0' : 0;
            int b = n2>=0 ? num2.charAt(n2)-'0' : 0;
            int x = a + b + add;
            sb.append(x%10);
            add = x / 10;
            n1--;
            n2--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "100";
        String num2 = "100";
        System.out.println(addStrings(num1, num2));
    }
}
