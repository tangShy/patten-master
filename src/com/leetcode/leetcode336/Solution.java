package com.leetcode.leetcode336;

import java.util.ArrayList;
import java.util.List;

/**
 * 336. 回文对  --hard
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]]
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2：
 *
 * 输入：["bat","tab","cat"]
 * 输出：[[0,1],[1,0]]
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //暴力法——超出时间限制
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words.length; j++){
                temp = new ArrayList<>();
                if(j==i) continue;
                if(isRevers(words[i], words[j])){
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static boolean isRevers(String words1, String words2){
        String str = words1 + words2;
        int n = str.length();
        for (int i=0; i<n/2; i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a","abc","aba",""};
        System.out.println(palindromePairs(words));
    }


}
