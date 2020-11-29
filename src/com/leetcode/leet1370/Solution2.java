package com.leetcode.leet1370;

//官方题解
public class Solution2 {
    public static String sortString(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int j = 0; j < 26; j++) {
                if (num[j] > 0) {
                    sb.append((char)(j + 'a'));
                    num[j]--;
                }
            }
            for (int k = 25; k >= 0; k--) {
                if (num[k] > 0) {
                    sb.append((char)(k + 'a'));
                    num[k]--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));
    }
}
